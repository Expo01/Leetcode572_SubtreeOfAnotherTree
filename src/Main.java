import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}
// BEST SOLUTION- BREADTH FIRST SEARCH WHERE SUBTREE IS EITHER ROOT.LEFT OR ROOT.RIGHT == SUBROOT AND NOT
// WHAT I THOUGHT OF FINDING ANY SUBTREE WITHIN THE MAIN TRREE WHICH SUPPOSE SUBROOT IS ONLY 3 NODES AND MAIN
// TREE IS 1,000 NODES (500 PER SIDE) THIS WOULD NOT BE EQUIVALENT EVEN IF THE SMALLEST SUBTREE OF 3 FROM MAIN
// TREE EQUALS THE SUBROOT

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false; // If the main root is null, then false
        if (isSame(s, t)) return true; // if s == t, we  don't need to compare a subtree and just return true
        return isSubtree(s.left, t) || isSubtree(s.right, t); // we compare each of the two primary subtrees of
        // the main rootNode and if either is equivalent to subroot, then return true
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true; // if base case reached return null
        if (s == null || t == null) return false; // if one has ended but not other, not equivalent -> false

        if (s.val != t.val) return false; // if values are not same then false

        return isSame(s.left, t.left) && isSame(s.right, t.right); // recrusive call meaning nodes are the same
        // and base case not reached. continue in breadth first search fashion and must return that left
        // and right are true since all subtree nodes must be ==
    }
}

// GOOD SOLUTION TO A DIFFERENT PROBLEM. MISUNDERSTOOD
//class Solution {
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        TreeNode newRoot = null;
//
//        while (root.left != null && root.right != null) {
//            if (subRoot.val < root.val) {
//                root = root.left;
//            } else if (subRoot.val > root.val) {
//                root = root.right;
//            } else {
//                newRoot = root;
//            }
//        }
//
//        if (newRoot == null) {
//            return false;
//        }
//
//        return compareSubTrees(newRoot, subRoot);
//
//    }
//
//    private boolean compareSubTrees(TreeNode root, TreeNode subRoot) {
//        if (root == null && subRoot == null) {
//            return true;
//        }
//
//        if (root.left.val == subRoot.left.val) {
//            compareSubTrees(root.left, subRoot.left);
//        }
//        if (root.right.val == subRoot.right.val) {
//            compareSubTrees(root.right, subRoot.right);
//        }
//        return false;
//    }
//}

// concept: search for subroot in root. if L and R of root and subroot ==, return true.
// this is easy if both L and R of root/subroot are leaves, but need recursion after root //// found, so second method. subroot can be found iteratively
// after subroot passed, need to find base case. say if both root/sub have left then
// reecursively call. once null found, start comparing values. same thing with calling.