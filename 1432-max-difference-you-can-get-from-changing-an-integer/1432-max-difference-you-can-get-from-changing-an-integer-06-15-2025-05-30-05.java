class Solution {
    public int maxDiff(int num) {
        String number = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int valueToChange = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            if(number.charAt(i)!='9'){
                valueToChange = number.charAt(i);
                break;
            }
        }
        int maxValue = 0;
        if(valueToChange!=Integer.MAX_VALUE){
            for(char ch : number.toCharArray()){
                if(ch==valueToChange) sb.append('9');
                else sb.append(ch);
            }
            maxValue = Integer.parseInt(sb.toString());
        }
        else maxValue = num;
        
        sb.setLength(0);
        valueToChange = Integer.MAX_VALUE;
        int toValue = 0;
        if(number.charAt(0)!='1'){
            valueToChange = number.charAt(0);
            toValue = 1;
        } 
        else{
            for(int i=1; i<len; i++){
                if(number.charAt(i)!='0' && number.charAt(i)!='1'){
                    valueToChange = number.charAt(i);
                    toValue = 0;
                    break;
                } 
            }
        }
        int minValue = 0;
        if(valueToChange == Integer.MAX_VALUE) minValue = num;
        else {
            for(char ch : number.toCharArray()){
                if(ch==valueToChange) sb.append(toValue);
                else sb.append(ch);
            }
            minValue = Integer.parseInt(sb.toString());
        }
        return maxValue-minValue;

    }
}