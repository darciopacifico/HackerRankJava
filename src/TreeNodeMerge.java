public class TreeNodeMerge {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {


        return null;
    }


}

class TreeNode {
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    int val;
    TreeNode left;
    TreeNode right;


    @Override
    public String toString() {
        return "" + this.val;
    }
}

