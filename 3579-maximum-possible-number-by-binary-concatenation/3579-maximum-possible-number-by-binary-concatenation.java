class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] bin = new String[nums.length];
        for(int i=0; i<bin.length; i++){
            bin[i] = Integer.toBinaryString(nums[i]);
        }
        int[] ans = new int[1];
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[nums.length];
        helperRec(bin,ans,sb,used);
        return ans[0];
    }

    public void helperRec(String[] bin, int[] ans, StringBuilder sb, boolean[] used){
        boolean allUsed = true;
        for(boolean bool : used){
            if(!bool) allUsed = false;
        }
        if(allUsed) ans[0] = Math.max(ans[0],Integer.parseInt(sb.toString(),2));
        else{
            for(int i=0; i<bin.length; i++){
                if(!used[i]){
                    int len = sb.length();
                    int chosenSize = bin[i].length();
                    sb.append(bin[i]);
                    used[i] = true;
                    helperRec(bin,ans,sb,used);
                    used[i] = false;
                    sb.delete(len,len+chosenSize);
                }
            }
        }
    }
}