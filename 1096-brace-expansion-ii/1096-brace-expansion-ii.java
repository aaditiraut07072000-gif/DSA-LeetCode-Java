import java.util.*;

class Solution {
    
    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        
        return ans;
    }

    private Set<String> dfs(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            // Case 1: Letter
            if (ch >= 'a' && ch <= 'z') {
                Set<String> next = new HashSet<>();

                for (String word : current) {
                    next.add(word + ch);
                }

                current = next;
                i++;
            }

            // Case 2: Opening brace
            else if (ch == '{') {
                int start = i + 1;
                int count = 1;
                i++;

                // Find matching '}'
                while (count > 0) {
                    if (s.charAt(i) == '{') {
                        count++;
                    } else if (s.charAt(i) == '}') {
                        count--;
                    }
                    i++;
                }

                String inside = s.substring(start, i - 1);

                Set<String> insideSet = parseUnion(inside);

                // Concatenate current × insideSet
                Set<String> next = new HashSet<>();

                for (String a : current) {
                    for (String b : insideSet) {
                        next.add(a + b);
                    }
                }

                current = next;
            }

            // Case 3: Comma
            else if (ch == ',') {
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> parseUnion(String s) {
        Set<String> result = new HashSet<>();

        int start = 0;
        int depth = 0;

        for (int i = 0; i <= s.length(); i++) {

            if (i < s.length()) {
                char ch = s.charAt(i);

                if (ch == '{') {
                    depth++;
                } else if (ch == '}') {
                    depth--;
                }
            }

            // Split only on top-level comma
            if (i == s.length() ||
                (s.charAt(i) == ',' && depth == 0)) {

                String part = s.substring(start, i);

                result.addAll(dfs(part));

                start = i + 1;
            }
        }

        return result;
    }
}