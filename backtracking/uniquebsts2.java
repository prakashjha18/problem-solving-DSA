/*
95. Unique Binary Search Trees II
Medium

2415

161

Add to List

Share
Given an integer n, generate all structurally unique BST's 
    (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3



 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<>();
        } 
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int low,int high){
        List<TreeNode> ans = new ArrayList<>();
        if(low>high){
            ans.add(null);
            return ans;
        }
        for(int i=low;i<=high;i++){
            List<TreeNode> leftlefttrees = generateTrees(low,i-1);
            List<TreeNode> rightsubtrees = generateTrees(i+1,high);
            for(TreeNode leftlefttree : leftlefttrees){
                for(TreeNode rightsubtree : rightsubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftlefttree;
                    root.right = rightsubtree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
