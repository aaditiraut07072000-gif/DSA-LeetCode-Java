class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int sumLeft = 0, sumRight = 0;
        int qLeft = 0, qRight = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?')
                qLeft++;
            else
                sumLeft += num.charAt(i) - '0';
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?')
                qRight++;
            else
                sumRight += num.charAt(i) - '0';
        }

        // Same number of ? on both sides
        if (qLeft == qRight) {
            return sumLeft != sumRight;
        }

        // Difference in number of ? is odd
        if ((qLeft - qRight) % 2 != 0) {
            return true;
        }

        // Difference is even
        int diff = sumLeft - sumRight;
        int qDiff = qLeft - qRight;

        return diff + (qDiff / 2) * 9 != 0;
    }
}