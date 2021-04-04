package trustrace;

import java.util.Scanner;

public class CustomException extends Exception {

    static void check(int a) throws ArithmeticException{
        if(a==0)
            a=1/a; // using throws clause
         else
            throw new IllegalArgumentException("Custom messages"); // using throw
    }

    public static void main(String[] args) {
        try{
            System.out.print("Enter value: ");
            Scanner scanner = new Scanner(System.in);
            check(scanner.nextInt());
        }catch(ArithmeticException e){
            System.out.println("Exception occurred..! "+e.getMessage());
        }catch(Exception e){
            System.out.println("We can use specified catch or Generic catch.Now is used generic catch... to catch  IllegalArgumentException.. "+e.getMessage());
        }
    }

}
