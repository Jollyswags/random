class Solution {
   public int maxConsecutiveAnswers(String answerKey, int k) {
	return Math.max(flipper(answerKey, k, 'F'), flipper(answerKey, k, 'T'));
}

public int flipper(String answerKey, int k, char countLetter) {
	int max = 0;
	int count = 0;
	LinkedList<Integer> queue = new LinkedList<>();
	for (int i = 0; i < answerKey.length(); i++) {
		char letter = answerKey.charAt(i);
		if (letter == countLetter) count++;
		else if (k > 0) {
			queue.add(i);
			k--;
			count++;
		} else {
			queue.add(i);
			max = Math.max(count, max);
			Integer firstEncountered = queue.removeFirst();
			count = i - firstEncountered;
		}
	}
	max = Math.max(count, max);
	return max;
}
}