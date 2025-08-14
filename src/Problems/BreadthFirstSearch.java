package Problems;
import java.util.*;
class BreadthFirstSearch {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(24,new TreeNode(14),new TreeNode(20));
        root.left.left=new TreeNode(19);
        root.left.right=new TreeNode(96);
        root.right.left=new TreeNode(35);
        root.right.right=new TreeNode(48);
        root.left.left.left=new TreeNode(67);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
            
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int level = que.size();
            List<Integer> currentLevel = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode currentNode = que.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    que.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    que.offer(currentNode.right);
                } 
            }
             result.add(currentLevel);
        }
        return result;
    }
}