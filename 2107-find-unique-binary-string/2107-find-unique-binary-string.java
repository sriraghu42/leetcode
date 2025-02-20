class Solution {
    String ans;
    boolean ansFound;
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder chosen = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String num : nums) set.add(num);
        int len = nums[0].length();
        helperRec(nums,len,set,chosen);
        return ans;
    }

    public void helperRec(String[] nums, int len, Set<String> set, StringBuilder chosen){
        if(chosen.length()==len){
            String str = chosen.toString();
            if(!set.contains(str)){
                ans = str;
                ansFound = true;
            }
            return;
        }

        for(int i=0; i<2; i++){
            chosen.append(i);
            if(ansFound) return;
            helperRec(nums,len,set,chosen);
            chosen.deleteCharAt(chosen.length()-1);
        }
    }
}