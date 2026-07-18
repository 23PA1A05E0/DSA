import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                String word = sc.next();
                trie.insert(word);
            }

            // Example queries
            System.out.println(trie.startWith("ap"));
            System.out.println(trie.startWith("a"));
            System.out.println(trie.startWith("b"));
            System.out.println(trie.startWith("xyz"));
        }
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        if (search(word))
            return;

        Node node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                node.put(new Node(), ch);
            }

            node = node.get(ch);      // Move first
            node.cntOcurance();      // Then increment count
        }

        node.setEnd();
    }

    public boolean search(String word) {

        Node node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch))
                return false;

            node = node.get(ch);
        }

        return node.isEnd();
    }

    public int startWith(String prefix) {

        Node node = root;

        for (char ch : prefix.toCharArray()) {

            if (!node.containsKey(ch))
                return 0;

            node = node.get(ch);
        }

        return node.getCnt();
    }

    public void printAllWords() {
        helper(root, new StringBuilder());
    }

    private void helper(Node root, StringBuilder sb) {

        if (root == null)
            return;

        if (root.isEnd()) {
            System.out.println(sb.toString());
        }

        for (int i = 0; i < 26; i++) {

            if (root.links[i] != null) {

                sb.append((char) ('a' + i));

                helper(root.links[i], sb);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<List<String>> suggestWords(String word){
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            sb.append(ch);
            ans.add(searchSuggestion(sb.toString()));
        }
        return ans;
    }

    public List<String> searchSuggestion(String prefix){
        List<String> subList = new ArrayList<>();
        Node node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch))
                return subList;
            node = node.get(ch);
        }
        StringBuilder sb = new StringBuilder(prefix);
        dfs(node, sb, subList);
        return subList;  
    }

    public void dfs(Node node, StringBuilder sb, List<String> subList){
        if(subList.size() == 3)
            return;
        if(node.isEnd())
            subList.add(sb.toString());
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(node.containsKey(ch)){
            sb.append(ch);
            dfs(node.get(ch), sb, subList);
            sb.deleteCharAt(sb.length() - 1);

            if(subList.size() == 3)
                return;
        }
            
        }
    }
}

class Node {

    Node[] links;
    boolean flag;
    int cnt;

    public Node() {
        links = new Node[26];
        flag = false;
        cnt = 0;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(Node node, char ch) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public void cntOcurances(){
        cnt++;
    }

    public int getCnt(){
        return cnt;
    }
}
