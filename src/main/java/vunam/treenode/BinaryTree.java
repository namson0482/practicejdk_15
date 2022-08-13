package vunam.treenode;

public class BinaryTree {

    public static final class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public TreeNode addRecursive(TreeNode current, int val) {
            if (current == null) {
                current = new TreeNode(val);
            }
            if (value < current.value) {
                current.left = addRecursive(current, val);
            } else if (value > current.value) {
                current.right = addRecursive(current, val);
            } else {
                return current;
            }
            return current;
        }

        public void insert(TreeNode node, int value) {
            if (value < node.value) {
                if (node.left != null) {
                    insert(node.left, value);
                } else {
                    System.out.println("  Inserted " + value + " to left of Node " + node.value);
                    node.left = new TreeNode(value);
                }
            } else if (value > node.value) {
                if (node.right != null) {
                    insert(node.right, value);
                } else {
                    System.out.println("  Inserted " + value + " to right of Node " + node.value);
                    node.right = new TreeNode(value);
                }
            }
        }
    }

    public void add(int value) {
        root.addRecursive(root, value);
    }

    public void insertNode(int value) {
        root.insert(root, value);
    }

    TreeNode root;

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);

        bt.insertNode(2);
        bt.insertNode(3);
    }

}
