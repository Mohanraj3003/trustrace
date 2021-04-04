package trustrace;

import java.util.Scanner;

public class Recursion {

    static boolean palindrome(String str){

        if(str.length() == 0 || str.length() == 1)
            return true;
        if(str.charAt(0)==str.charAt(str.length()-1))
            return palindrome(str.substring(1,str.length()-1));

        return false;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String to check Palindrome or not: ");
        System.out.println(palindrome(scanner.nextLine()));
    }
}
