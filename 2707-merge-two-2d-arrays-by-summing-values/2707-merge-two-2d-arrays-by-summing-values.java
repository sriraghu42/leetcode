class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length){
            int leftId = nums1[i][0];
            int rightId = nums2[j][0];
            if(leftId == rightId){
                list.add(new int[] {leftId,nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
            else if(leftId<rightId){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            list.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }
        int[][] ans = new int[list.size()][2];
        for(int k=0; k<ans.length; k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}