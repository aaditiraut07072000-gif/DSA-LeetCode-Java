
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        solve(ans, "", 0, 0, n);
        
        return ans;
    }

    public void solve(List<String> ans, String s, int open, int close, int n) {
        
        // Base condition
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add opening bracket
        if (open < n) {
            solve(ans, s + "(", open + 1, close, n);
        }

        // Add closing bracket
        if (close < open) {
            solve(ans, s + ")", open, close + 1, n);
        }
    }
}