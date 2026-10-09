class Solution {
    public int minInsertions(String s) {
        int noofopb = 0;
        int extra = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                noofopb++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    extra++;
                }

                if (noofopb > 0) {
                    noofopb--;
                } else {
                    extra++;
                }
            }
        }

        return extra + noofopb * 2;
    }
}