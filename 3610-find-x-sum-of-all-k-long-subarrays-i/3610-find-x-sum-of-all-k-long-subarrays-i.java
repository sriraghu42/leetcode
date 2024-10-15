class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums.length-k+1];
        int counter=0;
        int i = 0;
        for(int j=0; j<nums.length; j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k){
                List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
                Collections.sort(list, (a, b) -> {
                int valueComparison = b.getValue().compareTo(a.getValue());
                if (valueComparison != 0) {
                    return valueComparison;
                } else {
                    return b.getKey().compareTo(a.getKey());
                }
                });
                int sum=0;
                if(list.size()<x){
                    for(int c=i; c<=j; c++){
                        sum+=nums[c];
                    }
                }
                else{
                    for(int m=0; m<x; m++){
                    sum+=list.get(m).getKey()*list.get(m).getValue();
                    }
                }
                ans[counter] = sum;
                counter++;
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }

        }
        return ans;
    }
}