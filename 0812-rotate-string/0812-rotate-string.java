class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        boolean check = true;
        int start = 0;
        while(check){
            int index = s.indexOf(goal.charAt(0),start);
            System.out.println(index);
            if(index==-1) return false;
            int i = index;
            int j = 0;
            while(j<goal.length()){
                if(s.charAt(i)!=goal.charAt(j)) break;
                if(j==goal.length()-1) return true;
                j++;
                i++;
                if(i==s.length()) i=0;
            }
            start = index+1;
        }
        return false;
    }
}