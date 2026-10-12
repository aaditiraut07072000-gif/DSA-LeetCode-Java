
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long no = 0;

            for (int bit = 30; bit >= 0; bit--) {
                if (bitCount[bit] > 0) {
                    no |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            ans = (ans + no * no) % MOD;
        }

        return (int) ans;
    }
}
