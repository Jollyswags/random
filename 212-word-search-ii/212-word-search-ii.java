class Solution {
    int[] delta = new int[]{-1, 0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        // construct trie
        TrieNode root = new TrieNode();
        constructTrie(root, words);
        // go through board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.next[board[i][j] - 'a'] != null) {
                    char temp = board[i][j];
                    board[i][j] = '-';
                    searchBoard(res, board, i, j, root.next[temp - 'a']);
                    board[i][j] = temp;
                }
            }
        }
        return res;
    }
    
    private void searchBoard(List<String> res, char[][] board, int i, int j, TrieNode cur) {
        
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        for (int k = 0; k < delta.length - 1; k++) {
            int newI = i + delta[k];
            int newJ = j + delta[k + 1];
            if (isValid(board, newI, newJ) && board[newI][newJ] != '-' && cur.next[board[newI][newJ] - 'a'] != null) {
                char temp = board[newI][newJ];
                board[newI][newJ] = '-';
                searchBoard(res, board, newI, newJ, cur.next[temp - 'a']);
                board[newI][newJ] = temp;
            }
        }
        boolean noChild = true;
        for (TrieNode n : cur.next) {
            if (n != null) {
                noChild = false;
                break;
            }
        }
        if (noChild) cur.parent.next[cur.cur - 'a'] = null;
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
    
    private void constructTrie(TrieNode root, String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                    cur.next[c - 'a'].parent = cur;
                    cur.next[c - 'a'].cur = c;
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = s;
        }
    }
    
    public class TrieNode {
        TrieNode parent;
        String word;
        TrieNode[] next;
        char cur;
        public TrieNode() {
            next = new TrieNode[26];
            word = null;
        }
        
    }
}