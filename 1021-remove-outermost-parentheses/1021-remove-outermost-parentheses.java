class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(') {
                // Add '(' only if it is NOT the outermost '('
                if (depth > 0) {
                    ans.append('(');
                }
                depth++;
            } 
            else {
                depth--;

                // Add ')' only if it is NOT the outermost ')'
                if (depth > 0) {
                    ans.append(')');
                }
            }
        }

        return ans.toString();
    }
}