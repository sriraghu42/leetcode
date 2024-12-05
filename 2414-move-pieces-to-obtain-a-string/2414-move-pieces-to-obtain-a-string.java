class Solution {
    public boolean canChange(String start, String target) {
        int[] count1 = new int[2];
        int[] count2 = new int[2];
        for(int i=0; i<start.length(); i++){
            if(start.charAt(i)=='L') count1[0]++;
            else if(start.charAt(i)=='R') count1[1]++;
            else ;
            if(target.charAt(i)=='L') count2[0]++;
            else if(target.charAt(i)=='R') count2[1]++;
        }
        if(count1[0]!=count2[0] || count1[1]!=count2[1]) return false;
        int i = 0;
        int j = 0;
        int n = start.length();
        while(i<n && j<n){
            while(i<n && start.charAt(i)=='_') i++;
            while(j<n && target.charAt(j)=='_') j++;
            if(i>=n && j>=n) return true;
            if(i>=n || j>=n) return false;
            char a = start.charAt(i);
            char b = target.charAt(j);
            if(a!=b) return false;
            if(a=='L' && i<j) return false;
            if(a=='R' && i>j) return false;
            i++;
            j++;
        }
        return true;
    }
}