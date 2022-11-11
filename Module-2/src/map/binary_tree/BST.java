package map.binary_tree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] object) {
        for (E e : object) {
            insert(e);
        }
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E e) {
        if (root == null) {
            System.out.println("Empty BST");
            return true;
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    break;
                }
            }
            TreeNode<E> currentTemp = current;
            if (current.left == null) {
                current = current.right;
                if (current.element.compareTo(parent.element) < 0) {
                    parent.left = current;
                } else if (current.element.compareTo(parent.element) > 0) {
                    parent.right = current;
                }
            } else {
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;
                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }
                currentTemp.element = rightMost.element;
                if (rightMost.left == null) {
                    parentOfRightMost.right = null;
                } else {
                    parentOfRightMost.right = parentOfRightMost.right.left;
                }
            }
        }
        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
