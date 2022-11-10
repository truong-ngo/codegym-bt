package map.binary_tree;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    void postorder();
    int getSize();
}
