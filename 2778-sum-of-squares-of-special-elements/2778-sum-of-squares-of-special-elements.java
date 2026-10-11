class Solution {
    public int sumOfSquares(int[] nums) {
        int l = nums.length;
        int sum = 0;
        for(int i = 0; i < l ; i++)
        {
            if(l % (i+1) == 0)
            {
                sum = sum + (nums[i]*nums[i]);
            }
        }
        return sum;
    }
}