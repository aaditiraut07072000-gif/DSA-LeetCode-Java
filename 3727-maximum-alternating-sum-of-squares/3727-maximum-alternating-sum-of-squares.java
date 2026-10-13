
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] l = new long[n];
        long score = 0;

        for (int i = 0; i < n; i++) {
            l[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(l);

        int n1 = n / 2;

        for (int i = 0; i < n; i++) {
            if (i < n1) {
                score = score - l[i];
            } else {
                score = score + l[i];
            }
        }

        return score;
    }
}
