import java.util.*;
public class SegmentTreeMin {
    Node root;
    public SegmentTreeMin(int arr[]){
        root = constructTree(arr, 0, arr.length - 1);
    }
    private Node constructTree(int[] arr, int start, int end) {
        Node node = new Node(start, end);
        if(start == end){
            node.data = arr[start];
            return node;
        }
        int mid =  start + (end - start) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = Math.min(node.left.data, node.right.data);
        return node;
    }

    public int query(int si, int ei){
        return query(root, si, ei);
    }

    private int query(Node root, int si, int ei){
        if(si <= root.startInterval && ei >= root.endInterval)
            return root.data;
        if(si > root.endInterval || ei < root.startInterval)
            return Integer.MAX_VALUE;
        int leftAns = query(root.left, si, ei);
        int rightAns = query(root.right, si, ei);
        return Math.min(leftAns, rightAns);
    }

    public void update(int idx, int value){
        update(root, idx, value);
    }

    private void update(Node root, int idx, int value){
        if(root.startInterval == root.endInterval){
            if(root.startInterval == idx)
                root.data = value;
            return;
        }
        int mid = root.startInterval + (root.endInterval - root.startInterval) / 2;
        if(idx < mid)
            update(root.left, idx, value);
        else
            update(root.right, idx, value);
        int left = root.left != null ? root.left.data : Integer.MAX_VALUE;
        int right = root.right != null ? root.right.data : Integer.MAX_VALUE;

        root.data = Math.min(left, right);
    }
}

class Node{
    int data;
    int startInterval;
    int endInterval;
    Node left;
    Node right;
    public Node(int si, int ei){
        this.startInterval = si;
        this.endInterval = ei;
    }
}
