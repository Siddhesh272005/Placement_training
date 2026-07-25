// Defanging an Ip address
public class DefangIP {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}

// Shuffle String
public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(s, indices));
    }
}

// Goal Parser Interpretation
public class GoalParser {
    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                result.append("G");
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append("o");
                i++;
            } else {
                result.append("al");
                i += 3;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
}

// Jump Game VII
import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameVII {
    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int maxReached = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int start = Math.max(i + minJump, maxReached + 1);
            int end = Math.min(i + maxJump, s.length() - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    if (j == s.length() - 1) {
                        return true;
                    }
                    queue.add(j);
                }
            }
            maxReached = Math.max(maxReached, i + maxJump);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach("011010", 2, 3));
    }
}

// Split Two Strings to Make Palindrome
public class SplitTwoStrings {
    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b) {
        int left = 0;
        int right = a.length() - 1;

        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }

        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("x", "y"));
    }
}

// Valid Number
public class ValidNumber {
    public static boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (c == '.') {
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0089"));
        System.out.println(isNumber("e3"));
    }
}

// Regular Expression Matching
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char prevPatternChar = p.charAt(j - 2);
                    if (prevPatternChar == sc || prevPatternChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
