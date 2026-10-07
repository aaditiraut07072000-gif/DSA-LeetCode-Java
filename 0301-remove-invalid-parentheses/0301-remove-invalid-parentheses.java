class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        // Find minimum number of '(' and ')' to remove
        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {
                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        // Backtracking
        solve(s, 0, left, right, 0, new StringBuilder(), result);

        return result;
    }

    private void solve(String s, int index, int leftRemove,
                       int rightRemove, int balance,
                       StringBuilder current,
                       List<String> result) {

        // If we reached the end
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                String str = current.toString();

                if (!result.contains(str)) {
                    result.add(str);
                }
            }

            return;
        }

        char ch = s.charAt(index);

        // Case 1: Current character is '('
        if (ch == '(') {

            // Remove '('
            if (leftRemove > 0) {
                solve(s, index + 1,
                      leftRemove - 1,
                      rightRemove,
                      balance,
                      current,
                      result);
            }

            // Keep '('
            current.append(ch);

            solve(s, index + 1,
                  leftRemove,
                  rightRemove,
                  balance + 1,
                  current,
                  result);

            current.deleteCharAt(current.length() - 1);
        }

        // Case 2: Current character is ')'
        else if (ch == ')') {

            // Remove ')'
            if (rightRemove > 0) {
                solve(s, index + 1,
                      leftRemove,
                      rightRemove - 1,
                      balance,
                      current,
                      result);
            }

            // Keep ')' only if it has a matching '('
            if (balance > 0) {
                current.append(ch);

                solve(s, index + 1,
                      leftRemove,
                      rightRemove,
                      balance - 1,
                      current,
                      result);

                current.deleteCharAt(current.length() - 1);
            }
        }

        // Case 3: Letter
        else {
            current.append(ch);

            solve(s, index + 1,
                  leftRemove,
                  rightRemove,
                  balance,
                  current,
                  result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}