class Solution {

    public boolean checkValidString(String s) {

        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                min++;
                max++;
            }

            else if (ch == ')') {
                min--;
                max--;
            }

            else {  // '*'
                min--;   // treat * as ')'
                max++;   // treat * as '('
            }

            // Too many ')' characters
            if (max < 0) {
                return false;
            }

            // min cannot be negative
            if (min < 0) {
                min = 0;
            }
        }

        return min == 0;
    }
}