// Build Array from Permutation
import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }
}

// Concatenation of Array
import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}

// Running Sum of 1d Array
import java.util.Arrays;

public class RunningSumOf1DArray {
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}

// Richest Customer Wealth
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bank : customer) {
                currentWealth += bank;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts));
    }
}
// Shuffle the Array
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bank : customer) {
                currentWealth += bank;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts));
    }
}
// Kids With the Greatest Number of Candies
import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}

// Number of Good Pairs
public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }
}
