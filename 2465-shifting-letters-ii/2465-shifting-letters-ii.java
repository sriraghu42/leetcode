class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] increment = new int[s.length() + 1]; // +1 to handle boundary cases

        // Step 1: Use difference array to record shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 0 ? -1 : 1; // 0 for left, 1 for right
            increment[start] += direction;
            increment[end + 1] -= direction; // Stop the effect after the range
        }

        // Step 2: Compute the cumulative shifts
        int cumulativeShift = 0;
        for (int i = 0; i < s.length(); i++) {
            cumulativeShift += increment[i];
            increment[i] = cumulativeShift;
        }

        // Step 3: Apply the shifts to the string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int shift = increment[i] % 26; // Handle cyclic shifts
            int newChar = ch + shift;
            if (newChar > 'z') newChar -= 26;
            if (newChar < 'a') newChar += 26;
            sb.append((char) newChar);
        }

        return sb.toString();
    }
}
