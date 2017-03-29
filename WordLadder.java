public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        if (!dict.contains(endWord)) return 0;
// no word in dict     
        if (dict.size() == 0) return 0;
// queue to store words and distances from beginWord
        Queue<String> words = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        words.offer(beginWord);
        dist.offer(1);
        
        while (!words.isEmpty()) {
            String curr = words.poll();
            int currDist = dist.poll();
// find target
            if (curr.equals(endWord)) return currDist;

            int len = curr.length();
// try each position
            for (int i = 0; i < len; i++) {
                char[] currArray = curr.toCharArray();
// try each character
                for (char j = 'a'; j <= 'z'; j++) {
                    currArray[i] = j;
                    String newCurr = String.valueOf(currArray);
// intermediate word in dict
                    if (dict.contains(newCurr)) {
                        words.offer(newCurr);
                        dist.offer(currDist + 1);
                        dict.remove(newCurr);
                    }
                }
            }
        }
        return 0;
    }
}