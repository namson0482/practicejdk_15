package vu.son.leetcode.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Son Vu
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
 * that their sum is equal to the given target.
 */
public class TwoSumBST {

    public boolean findTarget(TreeNode root, int k) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode > q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            TreeNode node = q.peek();
            int complement = k - node.val;
            if(map.containsKey(complement)) {
                return true;
            } else {
                map.put(node.val, node);
            }
            q.remove();
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {


        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, node7);

        TreeNode root = new TreeNode(5, node3, node6);

        TwoSumBST twoSumBST = new TwoSumBST();
        System.out.println(twoSumBST.findTarget(root, 9));
    }
}
