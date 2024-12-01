class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Float> set = new HashSet<>();
        for(int num : arr){
            if(set.contains((float) num/2) || set.contains((float) num*2)) return true;
            set.add((float) num);
        }
        return false;
    }
}