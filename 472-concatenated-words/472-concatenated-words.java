class Solution {
class Trie {
        
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

	TrieNode root = new TrieNode();

	void addWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (cur.children[c] == null) {
				cur.children[c] = new TrieNode();
			}
			cur = cur.children[c];
		}
		cur.word = word;
	}

	List<String> findAll(String[] words) {
		List<String> res = new ArrayList<>();

		for (String word : words) {
			if (backtrack(0, "", word, res, false)) {
				res.add(word);
			}
		}

		return res;
	}

	private boolean backtrack(int start, String curStr, String word, List<String> res, boolean isConcat) {
		// Base case
		if (start == word.length()) {
			return isConcat;
		}

		TrieNode cur = root;
		for (int i = start; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (cur.children[c] == null) return false;
			if (cur.children[c].word != null) {
				if (backtrack(i + 1, curStr + cur.children[c].word, word, res, i == word.length() - 1 ? isConcat : true)) return true;
			}
			cur = cur.children[c];
		}
		return false;
	}

}

public List<String> findAllConcatenatedWordsInADict(String[] words) {
	Trie trie = new Trie();
	for (String word : words) trie.addWord(word);
	return trie.findAll(words);
}
}