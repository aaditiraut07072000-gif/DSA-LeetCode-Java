class Solution {

    public int minAddToMakeValid(String s) {

        int open = 0;
        int e = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } 
            else {
                if (open > 0) {
                    open--;
                } 
                else {
                    e++;
                }
            }
        }

        return e + open;
    }
}