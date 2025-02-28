class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<nums2.length; i++){
            while(!stack.isEmpty() && nums2[i]>nums2[stack.peek()]) map.put(nums2[stack.pop()],nums2[i]);
            stack.push(i);
        }
        System.out.println(map);
        while(!stack.isEmpty()) map.put(nums2[stack.pop()],-1);
        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}