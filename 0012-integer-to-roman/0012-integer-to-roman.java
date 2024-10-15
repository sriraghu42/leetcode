class Solution {
    public String intToRoman(int num) {
        String[] rom = new String[] {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] nums = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int d = 0 ;
            int e = nums.length-1;
            while(d<=e){
                int f = d + (e-d)/2;
                if(nums[f]<=num) d=f+1;
                else e=f-1;
            }
            sb.append(rom[e]);
            num-=nums[e];
        }
        return sb.toString();
    }
}