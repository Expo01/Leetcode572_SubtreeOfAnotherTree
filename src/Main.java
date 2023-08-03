import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode newRoot = null;

        while (root.left != null && root.right != null) {
            if (subRoot.val < root.val) {
                root = root.left;
            } else if (subRoot.val > root.val) {
                root = root.right;
            } else {
                newRoot = root;
            }
        }

        if (newRoot == null) {
            return false;
        }

        return compareSubTrees(newRoot, subRoot);

    }

    private boolean compareSubTrees(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root.left.val == subRoot.left.val) {
            compareSubTrees(root.left, subRoot.left);
        }
        if (root.right.val == subRoot.right.val) {
            compareSubTrees(root.right, subRoot.right);
        }
        return false;
    }
}

// concept: search for subroot in root. if L and R of root and subroot ==, return true.
// this is easy if both L and R of root/subroot are leaves, but need recursion after root //// found, so second method. subroot can be found iteratively
// after subroot passed, need to find base case. say if both root/sub have left then
// reecursively call. once null found, start comparing values. same thing with calling