class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len%2!=0) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : changed){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Arrays.sort(changed);
        int[] ans = new int[len/2];
        int counter=0;
        for(int num : changed){
            if(!map.containsKey(num)) continue;
            if(num==0){
                if(map.get(0)>=2){
                    ans[counter]=0;
                    counter++;
                    map.put(0,map.get(0)-2);
                    if(map.get(0)==0) map.remove(0);
                }
            }
            else if(map.containsKey(num*2)){
                ans[counter] = num;
                map.put(num,map.get(num)-1);
                map.put(2*num,map.get(2*num)-1);
                if(map.get(num)==0) map.remove(num);
                if(map.get(2*num)==0) map.remove(2*num);
                counter++;
            }
        }
        if(counter==len/2) return ans;
        return new int[0];

    }
}
