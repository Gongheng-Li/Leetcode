class Trie {

    Node sentinel;

    private static class Node {
        Node[] digits;
        boolean[] endWith;

        public Node() {
            digits = new Node[26];
            endWith = new boolean[26];
        }
    }

    public Trie() {
        sentinel = new Node();
    }

    public void insert(String word) {
        Node node = sentinel;
        for (int i = 0; i < word.length(); i++) {
            if (node.digits[word.charAt(i) - 'a'] == null) {
                node.digits[word.charAt(i) - 'a'] = new Node();
            }
//            if (i == word.length() - 1) {
//                node.endWith[word.charAt(i) - 'a'] = true;
//            }
            node = node.digits[word.charAt(i) - 'a'];
        }
        node.endWith[word.charAt(word.length() - 1) - 'a'] = true;
    }

    public boolean search(String word) {
        Node node = sentinel;
        for (int i = 0; i < word.length(); i++) {
            if (node.digits[word.charAt(i) - 'a'] == null) {
                return false;
            }
//            if (i == word.length() - 1) {
//                return node.endWith[word.charAt(i) - 'a'];
//            }
            node = node.digits[word.charAt(i) - 'a'];
        }
        return node.endWith[word.charAt(word.length() - 1) - 'a'];
    }

    public boolean startsWith(String prefix) {
        Node node = sentinel;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.digits[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.digits[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}