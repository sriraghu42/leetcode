class Solution {
    public int numberOfBeams(String[] bank) {
        int laserCount = 0;
        int prevCount = 0;
        int currentCount = 0;
        int length = bank.length;
        for(int i=0; i<length; i++){
            String row = bank[i];
            for(int j=0; j<row.length(); j++){
                char ch = row.charAt(j);
                if(ch=='1') currentCount++;
            }
            if(currentCount>0){
                laserCount+=prevCount*currentCount;
                prevCount = currentCount;
                currentCount = 0;
            }
        }
        return laserCount;
    }
}