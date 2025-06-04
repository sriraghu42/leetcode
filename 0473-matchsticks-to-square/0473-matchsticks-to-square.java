class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num : matchsticks) sum+=num;
        if(sum%4!=0) return false;
        int target = sum/4;
        int len = matchsticks.length;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return search(matchsticks,len,0,target,0,0,0,0);
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public boolean search(int[] matchsticks, int len, int index, int target, int oneSum, int twoSum, int threeSum, int fourSum){
        if(oneSum>target || twoSum>target || threeSum>target || fourSum>target) return false;
        if(oneSum==target && twoSum==target && threeSum==target && fourSum==target) return true;
        if(index==len) return false;
        return search(matchsticks,len,index+1,target,oneSum+matchsticks[index],twoSum,threeSum,fourSum) ||
        search(matchsticks,len,index+1,target,oneSum,twoSum+matchsticks[index],threeSum,fourSum) ||
        search(matchsticks,len,index+1,target,oneSum,twoSum,threeSum+matchsticks[index],fourSum) ||
        search(matchsticks,len,index+1,target,oneSum,twoSum,threeSum,fourSum+matchsticks[index]);
    }
}
