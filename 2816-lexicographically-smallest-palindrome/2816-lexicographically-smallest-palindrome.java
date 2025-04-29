class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] newArr = new char[s.length()];
        int i = 0;
        int j = s.length()-1;
        int smallest = -1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                smallest = i;
            }
            else if(s.charAt(i)<s.charAt(j)){
                smallest = i;
            }
            else if(s.charAt(i)>s.charAt(j)){
                smallest = j;
            }
            newArr[i] = s.charAt(smallest);
            newArr[j] = s.charAt(smallest);
            i++;
            j--;
        }
        if(i==j){
            newArr[i] = s.charAt(i);
        }
        return new String(newArr);
    }
}