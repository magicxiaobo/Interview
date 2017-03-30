package fromCareerCup;

import java.util.ArrayList;
import java.util.List;

/**
 * Path sum: find all the paths whose sum mod 5 is zero.
 * the path must start from root and can stop at any node
 */
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class PathSumIV {
    public List<List<Integer>> pathSum(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        int sum = root.val;
        dfs(root, res, list, sum);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
        if (sum % 5 == 0) {
            res.add(new ArrayList<>(list));
        }

        if (root.left != null) {
            list.add(root.left.val);
            dfs(root.left, res, list, sum + root.left.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            dfs(root.right, res, list, sum + root.right.val);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(7);
        TreeNode four = new TreeNode(-3);
        TreeNode five = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        PathSumIV pathSumIV = new PathSumIV();

        List<List<Integer>> res = pathSumIV.pathSum(one);

        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
