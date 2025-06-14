class Solution {
    public int minMaxDifference(int num) {
        StringBuilder sb = new StringBuilder();
        String number = String.valueOf(num);
        int maxPosition = 0;
        while(maxPosition<number.length() && number.charAt(maxPosition)=='9') maxPosition++;
        char valueToChange = (maxPosition<number.length()?number.charAt(maxPosition):'a');
        for(char ch : number.toCharArray()){
            if(ch==valueToChange) sb.append(9);
            else sb.append(ch);
        }
        int maxValue = Integer.parseInt(sb.toString());
        sb.setLength(0);
        valueToChange = number.charAt(0);
        for(char ch : number.toCharArray()){
            if(ch==valueToChange) sb.append(0);
            else sb.append(ch);
        }
        int minValue = Integer.parseInt(sb.toString());
        return maxValue - minValue;
    }
}