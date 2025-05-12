class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0; i<n; i++){
            if(digits[i]==0) continue;
            int sum1 = digits[i];
            for(int j=0; j<n; j++){
                if(j==i) continue;
                int sum2 = sum1*10+digits[j];
                for(int k=0; k<n; k++){
                    if(k==i || k==j || digits[k]%2!=0) continue;
                    int sum3 = sum2*10+digits[k];
                    set.add(sum3);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(null);
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}

/*
2 1


2
1 3
1 0
3 1
3 0

0
2 1
2 3
1 2
1 3
3 2
3 1
*/