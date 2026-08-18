class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51];

        // Check every subarray of size k
        for (int i = 0; i <= n - k; i++) {

            // Avoid counting the same number twice
            // within the same subarray
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                int x = nums[j];

                if (!seen[x]) {
                    count[x]++;
                    seen[x] = true;
                }
            }
        }

        // Find the largest number appearing
        // in exactly one subarray
        int answer = -1;

        for (int x = 0; x <= 50; x++) {
            if (count[x] == 1) {
                answer = x;
            }
        }

        return answer;
    }
}