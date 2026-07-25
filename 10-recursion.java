// Sum Triangle from Array GFG
import java.util.Arrays;

public class SumTriangle {
    public static void printTriangle(int[] A) {
        if (A.length < 1) {
            return;
        }
        int[] temp = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            temp[i] = A[i] + A[i + 1];
        }
        printTriangle(temp);
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        printTriangle(A);
    }
}

// Maximum and Minimum value in an array GFG
public class MaxMinArray {
    public static class Pair {
        int min;
        int max;
    }

    public static Pair getMinMax(int[] arr, int low, int high) {
        Pair result = new Pair();
        if (low == high) {
            result.min = arr[low];
            result.max = arr[low];
            return result;
        }
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result.max = arr[low];
                result.min = arr[high];
            } else {
                result.max = arr[high];
                result.min = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        Pair left = getMinMax(arr, low, mid);
        Pair right = getMinMax(arr, mid + 1, high);

        result.min = Math.min(left.min, right.min);
        result.max = Math.max(left.max, right.max);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        Pair minmax = getMinMax(arr, 0, arr.length - 1);
        System.out.println("Minimum: " + minmax.min);
        System.out.println("Maximum: " + minmax.max);
    }
}

// Binary Search using recursion leetcode
public class BinarySearchRecursion {
    public static int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return helper(nums, target, left, mid - 1);
        } else {
            return helper(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
    }
}

// Combination Sum leetcode
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }
}

// Word Search leetcode
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
    }
}

// Parsing A Boolean Expression leetcode
import java.util.ArrayDeque;
import java.util.Deque;

public class ParseBooleanExpression {
    public static boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == ' ') {
                continue;
            }
            if (ch != ')') {
                stack.push(ch);
            } else {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        hasTrue = true;
                    }
                    if (val == 'f') {
                        hasFalse = true;
                    }
                }
                stack.pop();
                char operator = stack.pop();

                if (operator == '!') {
                    stack.push(hasTrue ? 'f' : 't');
                } else if (operator == '&') {
                    stack.push(hasFalse ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(hasTrue ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }

    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}

// Special Binary String
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    public static String makeLargestSpecial(String s) {
        int count = 0;
        int i = 0;
        List<String> res = new ArrayList<>();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }

        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }
}
