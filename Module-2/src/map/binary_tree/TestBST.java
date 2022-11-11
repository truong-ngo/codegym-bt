package map.binary_tree;

public class TestBST {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Will");
        tree.insert("Oliver");
        tree.insert("Quinn");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("Postorder (sorted): ");
        tree.postorder();
        System.out.println("Preorder (sorted): ");
        tree.preorder();
        System.out.println("Delete: ");
        tree.delete("Tom");
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        if (tree.search("Adam")) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
