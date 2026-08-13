class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        SegmentTree tree = new SegmentTree(s);
        int q = queryIndices.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            tree.update(idx, ch);
            ans[i] = tree.getMax();
        }
        return ans;
    }
}

class SegmentTree {
    Node[] tree;
    int n;

    SegmentTree(String s) {
        n = s.length();
        tree = new Node[4 * n];
        build(1, 0, n - 1, s);
    }

    void build(int node, int l, int r, String s) {
        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }
        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int idx, char ch) {
        update(1, 0, n - 1, idx, ch);
    }

    void update(int node, int l, int r, int idx, char ch) {
        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(node * 2, l, mid, idx, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, ch);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node left, Node right) {
        Node res = new Node();

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.prefix = left.prefix;
        res.suffix = right.suffix;

        res.max = Math.max(left.max, right.max);

        // Characters at the boundary are equal
        if (left.rightChar == right.leftChar) {

            res.max = Math.max(
                res.max,
                left.suffix + right.prefix
            );

            // Entire left segment has same character
            if (left.prefix == left.length) {
                res.prefix = left.length + right.prefix;
            }

            // Entire right segment has same character
            if (right.suffix == right.length) {
                res.suffix = right.length + left.suffix;
            }
        }

        res.length = left.length + right.length;

        return res;
    }

    int getMax() {
        return tree[1].max;
    }
}

class Node {

    char leftChar;
    char rightChar;

    int prefix;
    int suffix;
    int max;

    int length;

    Node() {
    }

    Node(char ch) {

        leftChar = ch;
        rightChar = ch;

        prefix = 1;
        suffix = 1;
        max = 1;

        length = 1;
    }
}
