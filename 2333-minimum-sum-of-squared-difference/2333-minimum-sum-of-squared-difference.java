
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            long count = Math.min(k, (long) freq[d]);
            freq[d] -= (int) count;
            freq[d - 1] += (int) count;
            k -= count;
        }

        long answer = 0;

        for (int d = 0; d < freq.length; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}
