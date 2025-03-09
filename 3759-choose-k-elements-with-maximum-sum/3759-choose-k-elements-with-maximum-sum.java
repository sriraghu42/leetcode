import java.util.*;

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];

        // Step 1: Store (nums1[i], nums2[i], index) and sort by nums1[i]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{nums1[i], nums2[i], i});
        }
        list.sort(Comparator.comparingInt(a -> a[0])); // Sort by nums1[i] ascending

        // Step 2: Min-Heap to track the largest k values of nums2[j]
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long sumHeap = 0;
        int j = 0; // Pointer to track previous elements

        for (int i = 0; i < n; i++) {
            int num1_i = list.get(i)[0]; // Current nums1[i]
            int num2_i = list.get(i)[1]; // Current nums2[i]
            int index_i = list.get(i)[2]; // Original index

            // Add elements from previous indices nums1[j] < nums1[i]
            while (j < i && list.get(j)[0] < num1_i) {
                int num2_j = list.get(j)[1];
                pq.add(num2_j);
                sumHeap += num2_j;

                // If more than k elements, remove the smallest
                if (pq.size() > k) {
                    sumHeap -= pq.poll();
                }
                j++;
            }

            // Store the max sum if at least one element exists, else 0
            ans[index_i] = (pq.size() > 0) ? sumHeap : 0;
        }

        return ans;
    }
}
