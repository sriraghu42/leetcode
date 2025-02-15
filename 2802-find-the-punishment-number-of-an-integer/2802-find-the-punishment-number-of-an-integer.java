class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++){
            int prod = i * i;
            if(check(String.valueOf(prod),i,0,0)) sum+=prod;
        }
        return sum;
    }

    public boolean check(String num, int n, int currSum, int k){
        if(k==num.length()) return currSum==n;
        int value = 0;
        for(int i=k; i<num.length(); i++){
            value = value*10 + (num.charAt(i)-'0');
            if(currSum>n) return false;
            if(check(num,n,currSum+value,i+1)) return true;
        }
        return false;
    }
}