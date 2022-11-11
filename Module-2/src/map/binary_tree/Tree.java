package map.binary_tree;

public interface Tree<E> {
    boolean insert(E e);
    boolean delete(E e);
    boolean search(E e);
    void inorder();
    void postorder();
    void preorder();
    int getSize();
}
