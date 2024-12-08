class Solution {
    public int maxTwoEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, (a,b) -> a[1]-b[1]);
        int[] maxArr = new int[events.length];
        int max = 0;
        for(int i=0; i<events.length; i++){
            max = Math.max(max,events[i][2]);
            maxArr[i] = max;
        }
        for(int i=0; i<events.length; i++){
            int[] event = events[i];
            ans = Math.max(ans,event[2]);
            int left = 0;
            int right = i-1;
            while(left<=right){
                int mid = left + (right - left)/2;
                if(events[mid][1]>=event[0]){
                    right = mid - 1;
                }
                else left = mid + 1;
            }
            if(right!=-1) ans = Math.max(ans,event[2]+maxArr[right]);
        }
        return ans;
    }
}