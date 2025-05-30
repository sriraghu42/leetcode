class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diffArr = new int[n];
        for(int[] booking : bookings){
            diffArr[booking[0]-1]+=booking[2];
            if(booking[1]!=n) diffArr[booking[1]]-=booking[2];
        }
        for(int i=1; i<n; i++){
            diffArr[i]+=diffArr[i-1];
        }
        return diffArr;
    }
}