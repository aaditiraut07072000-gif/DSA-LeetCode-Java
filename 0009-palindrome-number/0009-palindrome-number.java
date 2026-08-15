class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)
        {
            return false;
        }
        int a= 0;
        int d= 0;
        int f= x;
        while(x!=0)
        {
            d=x%10;
            a=(a*10)+d;
            x=x/10;
        }
        if(f==a)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}