class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b) -> a-b);
        for(int num : nums1){
            add(num,left,right);
        }
        for(int num : nums2){
            add(num,left,right);
        }
        if(left.size()>right.size()) return (double) left.peek();
        return (left.peek()+right.peek())/2.0;
    }

    public void add(int num, PriorityQueue<Integer> left, PriorityQueue<Integer> right){
        if(left.isEmpty()) left.add(num);
        else{
            if(left.peek()<=num) right.add(num);
            else left.add(num);
        }
        if(left.size()<right.size()) left.add(right.poll());
        else if(left.size()-right.size()>1) right.add(left.poll());
    }
}