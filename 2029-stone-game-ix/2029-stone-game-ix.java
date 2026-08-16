class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        // Count remainders
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // Case 1: Number of 0-remainder stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // Case 2: Number of 0-remainder stones is odd
        return Math.abs(count[1] - count[2]) > 2;
    }
}