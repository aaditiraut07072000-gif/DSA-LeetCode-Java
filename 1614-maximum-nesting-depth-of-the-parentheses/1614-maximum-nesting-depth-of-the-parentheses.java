class Solution {
    public int maxDepth(String s) {
        int a = s.length();
        int no=0;
        int max=0;
        for (int i=0; i<a; i++)
        {
            if (s.charAt(i) == '(')
            {
                no++;
                max = Math.max(max,no);
            }
            else if (s.charAt(i) == ')')
            {
                no--;
            }
        }
        return max;
    }
}