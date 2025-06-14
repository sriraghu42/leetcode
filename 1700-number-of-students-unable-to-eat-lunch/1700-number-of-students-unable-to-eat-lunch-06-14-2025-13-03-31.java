class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] arr = new int[2];
        for(int student : students) arr[student]++;
        for(int i=0; i<sandwiches.length; i++){
            arr[sandwiches[i]]--;
            if(arr[sandwiches[i]]<0) return sandwiches.length-i;
        }
        return 0;
    }
}