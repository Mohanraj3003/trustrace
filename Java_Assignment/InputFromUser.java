package trustrace;

import java.util.Scanner;

public class InputFromUser {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter String: ");
            System.out.println(scanner.nextLine());
            System.out.print("Enter Integer Number: ");
            System.out.println(scanner.nextInt());
            System.out.print("Enter Float Number: ");
            System.out.println(scanner.nextFloat());
        }catch(Exception e){
            System.out.println("Enter the input in Correct Format"+e);
        }
    }
}
