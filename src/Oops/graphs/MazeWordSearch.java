package Oops.graphs;

import java.util.*;

class MazeWordSearch {
    public static class Node {
        Node[] arr = new Node[26];
        String word;
    }

    public static Node build(String[] words) {
        Node root = new Node();
        for (String s : words) {
            Node node = root;
            for (char c : s.toCharArray()) {
                if (node.arr[c - 'a'] == null) {
                    node.arr[c - 'a'] = new Node();
                }
                node = node.arr[c - 'a'];
            }
            node.word = s;

        }
        return root;
    }

    public static void dfs(char[][] board, int i, int j, Node node, Set<String> ans) {
        char c = board[i][j];
        if (c == '#' || node.arr[c - 'a'] == null) return;

        int n = board.length;
        int m = board[0].length;


        node = node.arr[c - 'a'];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, ans);
        if (j > 0) dfs(board, i, j - 1, node, ans);
        if (i < board.length - 1) dfs(board, i + 1, j, node, ans);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, ans);
        board[i][j] = c;
    }

    public static List<String> searchSecretCodes(char[][] board, String[] words) {
        Node root = build(words);
        int n = board.length;
        int m = board[0].length;
        Set<String> found = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] < 'a' || board[i][j] > 'z') continue;
                if (root.arr[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, found);
                }
            }
        }
        return new ArrayList<>(found);
    }

    static void main() {
        char[][]board={
                {'w', 'x'}, {'y','b'}
        };
        String[] words={"wxyb"};
        System.out.println(searchSecretCodes(board,words));
    }
}       
