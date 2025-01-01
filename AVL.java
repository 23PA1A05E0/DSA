import java.util.*;
class Node {
    int key,height;
    Node left,right;
    Node(int key){
        this.key = key;
        left = right = null;
        height = 0;
    }
}
public class AVL{
    public static int getHeight(Node node){
        return (node==null)?-1:node.height;
    }
    public static Node rotateWithLeftChild(Node k2){
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k1.height = Math.max(getHeight(k1.left),getHeight(k1.right))+1;
        k2.height = Math.max(getHeight(k2.left),getHeight(k2.right))+1; 
        return k1;
    }
    public static Node rotateWithRightChild(Node k3){
        Node k2  = k3.right;
        k3.right = k2.left;
        k2.left  = k3;
         k3.height = Math.max(getHeight(k3.left),getHeight(k3.right))+1;
        k2.height = Math.max(getHeight(k2.left),getHeight(k2.right))+1; 
        return k2;
    }
    public static Node DoubleRotationWithLeftChild(Node k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
     public static Node DoubleRotationWithRightChild(Node k1){
        k1.right = rotateWithRightChild(k1.right);
        return rotateWithLeftChild(k1);
    }
    public static Node insert(Node node,int key){
        if(node==null)
            return (new Node(key));
        if(key<node.key){
            node.left = insert(node.left,key);
            if (getHeight(node.left) - getHeight(node.right) == 2){
                if(key<node.left.key)
                    node = rotateWithLeftChild(node);
                else
                    node = DoubleRotationWithLeftChild(node);
            }
        }
        else if(key>node.key){
            node.right = insert(node.right,key);
             if (getHeight(node.left) - getHeight(node.right) == -2){
                if(key>node.right.key)
                    node = rotateWithRightChild(node);
                else
                    node = DoubleRotationWithRightChild(node);
            }
        }
       node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            
        return node;    
    }
    public static Node getMin(Node node){
        if(node == null || node.left==null)
            return node;
        return getMin(node.left);    
    }
    public static Node delete(Node node,int key){
        if(node==null)
            return node;
        if(key<node.key)
            node.left = delete(node.left,key);
        else if(key>node.key)
            node.right = delete(node.right,key);
        else{
            if(node.right!=null && node.left!=null){
                Node min = getMin(node.right);
                node.key = min.key;
                node.right = delete(node.right,min.key);
            }
            else
                node = (node.left==null)?node.right:node.left;
        } 
        if(node!=null){
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            if(getHeight(node.left) - getHeight(node.right) == 2){
                if (getHeight(node.left.left) >= getHeight(node.left.right))
                    node = rotateWithLeftChild(node);
                else
                    node = DoubleRotationWithLeftChild(node);
            }
            if(getHeight(node.left) - getHeight(node.right) == -2){
                if (getHeight(node.right.right) >= getHeight(node.right.left))
                    node = rotateWithRightChild(node);
                else
                    node = DoubleRotationWithRightChild(node);
            }
        }
        return node;
    }
    public static void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.key + "->");
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
