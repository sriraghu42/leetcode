class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        left.add(num);
        if(left.size()-right.size()>1) right.add(left.poll());
        if(!right.isEmpty() && left.peek()>right.peek()){
            int temp = left.poll();
            left.add(right.poll());
            right.add(temp);
        }
    }
    
    public double findMedian() {
        if(right.isEmpty()) return (double) left.peek();
        else if(right.size() == left.size()) return (left.peek()+right.peek())/2.0;
        else return (double) left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */