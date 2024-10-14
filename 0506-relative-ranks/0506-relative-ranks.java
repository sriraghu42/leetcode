class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] arr = score.clone();
        Arrays.sort(arr);
        // Reverse the sorted array
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        String[] ref = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<Math.min(score.length,3); i++){
            map.put(arr[i],ref[i]);
        }
        for(int i=3;i<score.length; i++){
            map.put(arr[i],String.valueOf(i+1));
        }
        String[] ans = new String[score.length];
        for(int i=0; i<score.length; i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}