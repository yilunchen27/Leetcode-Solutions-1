import java.util.*;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        List<TreeNode> queue=new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            res.add(queue.get(queue.size()-1).val);
            next.clear();
            while(!queue.isEmpty()) {
                TreeNode tmp = queue.get(0);
                queue.remove(0);
                if (tmp == null) continue;
                if (tmp.left != null) next.add(tmp.left);
                if (tmp.right != null) next.add(tmp.right);
            }
            queue = new LinkedList<TreeNode>(next);
        }
        return res;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        List<Integer> rt = new ArrayList<>();
        
        rt.add(root.val);
        
        List<Integer> left  = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        
        rt.addAll(right);
        
        if(left.size() > right.size()){
            rt.addAll(left.subList(right.size(), left.size()));
        }

        
        return rt;
    }
}
