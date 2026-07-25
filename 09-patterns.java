//  1. *****
//     *****
//     *****
//     *****
//     *****
public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 2.  *
//     **
//     ***
//     ****
//     *****
public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 3.  *****
//     ****
//     ***
//     **
//     *
public class Pattern3 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 4.  1
//     1 2
//     1 2 3
//     1 2 3 4
//     1 2 3 4 5
public class Pattern4 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

// 5.  *
//     **
//     ***
//     ****
//     *****
//     ****
//     ***
//     **
//     *
public class Pattern5 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int totalCols = i > n ? 2 * n - i : i;
            for (int j = 1; j <= totalCols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 6.       *
//         **
//        ***
//       ****
//      *****
public class Pattern6 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 7.   *****
//       ****
//        ***
//         **
//          *
public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
