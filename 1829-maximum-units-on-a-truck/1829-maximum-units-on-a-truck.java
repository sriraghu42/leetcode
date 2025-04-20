class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        int ans = 0;
        for(int i=0; i<boxTypes.length; i++){
            int[] box = boxTypes[i];
            int min = Math.min(box[0],truckSize);
            ans+=min*box[1];
            truckSize-=min;
            if(truckSize==0) break;
        }
        return ans;
    }
}