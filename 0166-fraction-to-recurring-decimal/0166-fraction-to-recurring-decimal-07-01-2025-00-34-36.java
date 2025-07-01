class Solution {
    public String fractionToDecimal(int num, int denom) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(num<0 && denom<0) ;
        else if(num<0 || denom<0) sb.append("-");
        long numerator = Math.abs((long) num);
        long denominator = Math.abs((long) denom);
        sb.append(numerator/denominator);
        long rem = (numerator % denominator);
        if(rem==0) return sb.toString();
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        map.put(rem,sb.length());
        while(rem>0){
            numerator = rem * 10;
            rem = (numerator%denominator);
            sb.append(numerator/denominator);
            if(map.containsKey(rem)){
                sb.insert(map.get(rem),"(");
                sb.append(')');
                break;
            }
            map.put(rem,sb.length());
        }
        return sb.toString();
    }
}