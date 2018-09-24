package company.fb.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.types.TreeNode;

public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);

        String str = Codec.serialize(root);
        System.out.println(str);
        root = Codec.deserialize(str);
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);

//        System.out.println(Codec.deserialize(Codec.serialize(null)));

//        System.out.println(Codec.deserialize(","));

    }
}

class Codec {

    // BFS solution

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder rst = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int size  = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curt = queue.poll();
                rst.append(curt == null ? "X" : curt.val);
                rst.append(",");
                if (curt != null) {
                    queue.offer(curt.left);
                    queue.offer(curt.right);
                }
            }
        }
        // trim all the null at the end
//        return rst.deleteCharAt(rst.length() - 1).toString();
        return rst.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        /*
         * The Java and Scala split methods operate in two steps like this:
         *   First, split the string by delimiter. The natural consequence is that
         *   if the string does not contain the delimiter, array with just the string is returned.
         *   Second, remove all the rightmost empty strings
         */
        List<String> list = Arrays.asList(data.split(","));
        if (list.isEmpty() || "X".equals(list.get(0))) return null;
        int curtIdx = 0;
        int nextIdx = 1;
        TreeNode root = new TreeNode(Integer.valueOf(list.get(curtIdx)));
        TreeNode curtNode = root;
        while (curtIdx < list.size()) {
            if (!"X".equals(list.get(curtIdx))) {
                if (!"X".equals(list.get(nextIdx))) {
                    curtNode.left = new TreeNode(Integer.valueOf(list.get(nextIdx)));
                }
                nextIdx++;
                if (!"X".equals(list.get(nextIdx))) {
                    curtNode.right = new TreeNode(Integer.valueOf(list.get(nextIdx)));
                }
                nextIdx++;
            }
            curtIdx++;
        }
        return root;
    }

}