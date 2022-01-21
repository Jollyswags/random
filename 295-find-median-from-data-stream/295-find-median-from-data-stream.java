class MedianFinder {
    
    PriorityQueue<Integer> left; // 4,3,2,1
    PriorityQueue<Integer> right; //1,2,3,4
    

    public MedianFinder() {
        left = new PriorityQueue<>((a, b)->b-a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) { //O(logN)
        if (left.size() == 0) {
            left.offer(num);
        } else if (num > left.peek()) { //O(1)
            right.offer(num);
            if (right.size() == left.size() + 2) { //adjust
                left.offer(right.poll());
            }
        } else {
            left.offer(num);
            if (left.size() == right.size() + 2) { // adjust
                right.offer(left.poll());
            }
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()+0.0) / 2;
        } else if (left.size() > right.size()) {
            return (left.peek() + 0.0);
        } else {
            return (right.peek() + 0.0);
        }
    }
}
