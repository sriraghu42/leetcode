class Solution {
    int counter;
    String ans="";
    public String getHappyString(int n, int k) {
        //PriorityQueue<String> pq = new PriorityQueue<(a,b)-> a.compareto(b)>;
        char[] arr = new char [] {'a','b','c'};
        StringBuilder chosen = new StringBuilder();
        backtrack(n,k,arr,chosen);
        return ans;
    }

    public void backtrack(int n, int k, char[] arr, StringBuilder chosen){
        if(chosen.length()==n){
            counter++;
            if(counter == k) ans = chosen.toString();
            return;
        }

        for(int i=0; i<3; i++){
            char ch = arr[i];
            if(chosen.length()>0 && chosen.charAt(chosen.length()-1)==ch) continue;
            chosen.append(ch);
            if(counter==k) return;
            backtrack(n,k,arr,chosen);
            chosen.deleteCharAt(chosen.length()-1);
        }
    }
}