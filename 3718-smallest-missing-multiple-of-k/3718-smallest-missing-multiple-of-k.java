class Solution {
    public int missingMultiple(int[] nums, int k) {
        for (int i = 1; ; i++) {
            int temp = k * i;
            boolean found = false;  
            for (int x : nums) {
                if (x == temp) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return temp;
            }
        }
    }
}