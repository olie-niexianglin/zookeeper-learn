import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2019/9/2
 * Time: 16:04
 * Desc: 字典树
 */
public class Trie {
    private Node root;
    private int size;
    public Trie() {
        root = new Node();
        this.size = 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] str = {"cat", "dog", "deer", "pan", "panda"};
        for (String s : str) {
            trie.add(s);
        }
        System.out.println(trie.contains("pan"));
    }

    //获得trie中的单词数量
    public int getSize() {
        return size;
    }

    //向trie中添加一个新的单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isEnd) {
            cur.isEnd = true;
            size++;
        }
    }

    //查询单词word是否在trie中
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isEnd;     //这里不直接返回true,是因为即使上面的循环结束后，这个单词的每一个字母在trie中都有，
        // 依然不能确定trie中有我们要查的这个单词
        // 比如trie中存有一个单词panda,而我们要查询的单词为pan时，
        // 虽然前三个字母都找到了，但是trie中并不存在pan这个单词，要看单词结束标志是否为true。
    }

    //查询是否在trie中是否有单词以prefix为前缀(前缀查询)
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char p = prefix.charAt(i);
            if (cur.next.get(p) == null)
                return false;
            cur = cur.next.get(p);
        }
        return true;
    }

    private class Node {

        public boolean isEnd; //单词结束标志
        public TreeMap<Character, Node> next;

        public Node(boolean isEnd) {
            this.isEnd = isEnd;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}