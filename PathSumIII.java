/*
Leetcode: 437

Path Sum III:
Find how many paths whose sum is equals to the given sum. The path can start any point and end any point, but must downward

https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method/2

Similar to Two Sum: hash map: key-> preSum, value-> frequency

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }
    public int dfs(TreeNode root, int target, int currSum, Map<Integer, Integer> map) {
        if (root == null) return 0;
        currSum += root.val;
        
        int res = map.getOrDefault(currSum - target, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        res += dfs(root.left, target, currSum, map) + dfs(root.right, target, currSum, map);
        // all used currSum must be deleted, otherwise will be reuse. 
	//For example, this currSum is gotten from left sub tree, if not delete, it will use in right subtree which is not correct
	// after run this algorithm, all values except {0, 1} are zero
	map.put(currSum, map.getOrDefault(currSum, 0) - 1);
        return res;
    }
}
