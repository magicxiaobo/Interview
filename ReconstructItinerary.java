c class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> route = new LinkedList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return route;
        
        // map: key: departure airport, value: the departure airport neighbors
        // priorityqueue which contains string, it will sort the string as lexical order
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets) {
            // if not contains ticket[0], it will create this entry and add this value
            targets.computeIfAbsent(ticket[0], k->new PriorityQueue<>()).add(ticket[1]);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            // stack 从底到顶即为返回结果
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }
        return route;
    }
}

