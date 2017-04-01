/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X").append(",");
        } else {
            sb.append(String.valueOf(root.val)).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    public TreeNode buildTree(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
