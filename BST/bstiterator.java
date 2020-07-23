/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {

        // Array containing all the nodes in the sorted order
        nodesSorted = new ArrayList<Integer>();
        
        // Pointer to the next smallest element in the BST
        index = -1;
        
        // Call to flatten the input binary search tree
        _inorder(root);
    }

    private void _inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        _inorder(root.left);
        nodesSorted.add(root.val);
        _inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index + 1 < this.nodesSorted.size();
    }
}
