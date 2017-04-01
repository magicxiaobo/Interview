c class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            // 1. 1 -> 10 -> 100
            if (curr * 10 <= n) {
                curr *= 10;
                //2. n=13, curr=10, next number will be 11, then 12,...
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                //3. n = 600, curr = 499, next number will be 5
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
