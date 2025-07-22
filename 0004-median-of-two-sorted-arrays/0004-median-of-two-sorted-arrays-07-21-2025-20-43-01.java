class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a);
        for(int num : nums1) left.add(num);
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b)->a-b);
        for(int num : nums2) right.add(num);
        while(!right.isEmpty() && left.size()<right.size()) left.add(right.poll());
        while(!right.isEmpty() && right.peek()<left.peek()) left.add(right.poll());
        while(left.size()-right.size()>1) right.add(left.poll());
        if(left.size()>right.size()) return (double) left.peek();
        return (left.peek() + right.peek())/2.0;
    }
}