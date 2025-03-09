class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] newColors = new int[2*colors.length];
        for(int i=0; i<colors.length; i++) newColors[i] = colors[i];
        for(int i=colors.length; i<2*colors.length; i++) newColors[i]=colors[i-colors.length];
        int i = 0;
        int j = 1;
        int counter=0;
        while(j<colors.length+k-1){
            if(newColors[j]==newColors[j-1]) {
                i=j;
            }
            if(j-i+1==k){
                counter++;
                i++;
            }
            j++;
        }
        return counter;
    }
}