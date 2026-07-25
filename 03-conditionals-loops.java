// Area Of Circle Java Program
import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();

        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);

        scanner.close();
    }
}

// Area Of Triangle
import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);

        scanner.close();
    }
}


// Area Of Rectangle Program
import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        double area = length * width;
        System.out.println("Area of Rectangle: " + area);

        scanner.close();
    }
}

// Area Of Isosceles Triangle
import java.util.Scanner;

public class AreaOfIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = 0.5 * base * height;
        System.out.println("Area of Isosceles Triangle: " + area);

        scanner.close();
    }
}

// Area Of Parallelogram
import java.util.Scanner;

public class AreaOfParallelogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = base * height;
        System.out.println("Area of Parallelogram: " + area);

        scanner.close();
    }
}

// Area Of Rhombus
import java.util.Scanner;

public class AreaOfRhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double diagonal1 = scanner.nextDouble();
        double diagonal2 = scanner.nextDouble();

        double area = 0.5 * diagonal1 * diagonal2;
        System.out.println("Area of Rhombus: " + area);

        scanner.close();
    }
}

// Area Of Equilateral Triangle
import java.util.Scanner;

public class AreaOfEquilateralTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side = scanner.nextDouble();

        double area = (Math.sqrt(3) / 4) * side * side;
        System.out.println("Area of Equilateral Triangle: " + area);

        scanner.close();
    }
}
