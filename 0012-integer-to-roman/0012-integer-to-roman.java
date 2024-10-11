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
        String n = String.valueOf(num);
        for(int i=0; i<n.length(); i++){
            int number =  (n.charAt(i)-'0') * (int) Math.pow(10,n.length()-i-1);
            while(number>0){
                if(number>=nums[nums.length-1]){
                    sb.append("M");
                    number-=1000;
                }
                else if(number==nums[0]){
                    sb.append("I");
                    number-=1;
                }
                else{
                    int d = 0 ;
                    int e = nums.length-1;
                    while(d<=e){
                        int f = d + (e-d)/2;
                        if(nums[f]<=number) d=f+1;
                        else e=f-1;
                    }
                    sb.append(map.get(nums[e]));
                    number-=nums[e];
                }
            }
        }
        return sb.toString();
    }
}