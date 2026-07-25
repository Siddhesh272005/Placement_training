// Define two methods to print the maximum and the minimum number respectively among three numbers entered by the user.
import java.util.Scanner;

public class MaxMin {
    public static void printMax(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("Maximum: " + max);
    }

    public static void printMin(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        System.out.println("Minimum: " + min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        printMax(num1, num2, num3);
        printMin(num1, num2, num3);

        scanner.close();
    }
}

// Define a program to find out whether a given number is even or odd.
import java.util.Scanner;

public class EvenOddMethod {
    public static void checkEvenOdd(int num) {
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        checkEvenOdd(num);

        scanner.close();
    }
}

// A person is eligible to vote if his/her age is greater than or equal to 18. Define a method to find out if he/she is eligible to vote.
import java.util.Scanner;

public class VotingEligibility {
    public static boolean isEligible(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        if (isEligible(age)) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        scanner.close();
    }
}

// Write a program to print the sum of two numbers entered by user by defining your own method.
import java.util.Scanner;

public class SumMethod {
    public static void printSum(double a, double b) {
        System.out.println("Sum: " + (a + b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        printSum(num1, num2);

        scanner.close();
    }
}

// Define a method that returns the product of two numbers entered by user.
import java.util.Scanner;

public class ProductMethod {
    public static double getProduct(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        double product = getProduct(num1, num2);
        System.out.println("Product: " + product);

        scanner.close();
    }
}
