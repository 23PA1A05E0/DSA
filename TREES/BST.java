import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

class BST {
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static Node getMin(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        return getMin(node.left);
    }
    public static Node delete(Node node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node min = getMin(node.right);
            node.key = min.key;
            node.right = delete(node.right, min.key);
        }
        return node;
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + " -> ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int opt;
        do {
            System.out.println("Enter the option: 1-insert 2-delete 3-display 4-stop");
            opt = sc.nextInt();
            int key;
            switch (opt) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    key = sc.nextInt();
                    root = insert(root, key);
                    break;
                case 2:
                    System.out.print("Enter the element to delete: ");
                    key = sc.nextInt();
                    root = delete(root, key);
                    break;
                case 3:
                    inOrder(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        } 
		while (opt != 4);
        sc.close();
    }
}
