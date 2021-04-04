package trustrace;

import java.util.Scanner;

public class MethodOverloading {

    static int area(int side){
        return side*side;
    }
    static float area(float length,float breadth){
        return length*breadth;
    }
    static float area(double radius){
        return (float)(3.14*radius*radius);
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.println("----------Area of Square-------");
        System.out.println("Enter length of Sides:");
        System.out.println("Area of the square "+area(scanner.nextInt() ));
        System.out.println("----------Area of Rectangle--------");
        System.out.println("Enter Length and Breadth:");
        System.out.println("Area of the Rectangle "+area(scanner.nextFloat(), scanner.nextFloat() ));
        System.out.println("----------Area of Circle-------");
        System.out.println("Enter Radius:");
        System.out.println("Area of the Circle "+area(scanner.nextDouble()));
    }
}
