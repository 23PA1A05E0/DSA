class SegmentTree{
    Node root;
    public SegmentTree(int arr[]){
        root = constructTree(arr, 0, arr.length - 1);
    }

    public Node constructTree(int arr[], int startInterval, int endInterval){
        Node node = new Node(startInterval, endInterval);
        if(startInterval == endInterval){
            node.data = arr[startInterval];
            return node;
        }
        int mid = startInterval + (endInterval - startInterval) / 2;
        node.left = constructTree(arr, startInterval, mid);
        node.right = constructTree(arr, mid + 1, endInterval);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int startInterval, int endInterval){
        return query(root, startInterval, endInterval);
    }

    public int query(Node root, int start, int end){
        if(start <= root.startInterval && end >= root.endInterval)
            return root.data;
        if(start > root.endInterval || end < root.startInterval)
                return 0;
        int leftAns = query(root.left, start, end);
        int rightAns = query(root.right, start, end);
        return leftAns + rightAns;
    }

    public void update(int index, int value){
        update(root, index, value);
    }

    public void update(Node root, int index, int value){
        if(root.startInterval == root.endInterval){
            if(root.startInterval == index){
                root.data = value;
            }
            return;
        }
        int mid = (root.startInterval + root.endInterval) / 2;
        if(index <= mid)
            update(root.left, index, value);
        else
            update(root.right, index, value);

        root.data = (root.left != null ? root.left.data : 0) + 
                (root.right != null ? root.right.data : 0);
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
