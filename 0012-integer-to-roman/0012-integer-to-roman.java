class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
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
            sb.append(map.get(nums[e]));
            num-=nums[e];
        }
        return sb.toString();
    }
}