/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Method One: Reursion
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null? left : right;
    }
}


// Method Two: Iteration
public class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        
        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}