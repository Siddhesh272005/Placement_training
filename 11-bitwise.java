// Add Binary
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}

// Single Number
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}

// Reverse Bits
public class ReverseBits {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}

// Subsets
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}

// Subsets II
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}

// Minimum Number of Flips to onvert Binary Matrix to zero matrix
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumFlipsToZeroMatrix {
    public static int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int startState = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    startState |= (1 << (i * n + j));
                }
            }
        }

        if (startState == 0) {
            return 0;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startState);
        visited.add(startState);
        int steps = 0;

        int[] dirs = {0, 0, 1, -1, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int k = 0; k < size; k++) {
                int state = queue.poll();

                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < n; c++) {
                        int nextState = state;

                        nextState ^= (1 << (r * n + c));

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dirs[d];
                            int nc = c + dirs[d + 1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                                nextState ^= (1 << (nr * n + nc));
                            }
                        }

                        if (nextState == 0) {
                            return steps;
                        }

                        if (!visited.contains(nextState)) {
                            visited.add(nextState);
                            queue.add(nextState);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0}, {0, 1}};
        System.out.println(minFlips(mat));
    }
}
