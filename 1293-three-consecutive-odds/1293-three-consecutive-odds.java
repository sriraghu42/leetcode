class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int j = 0;
        while(j<arr.length){
            if(arr[j]%2==0) i=j+1;
            if(j-i+1==3) return true;
            j++;
        }
        return false;
    }
}