package trustrace;

import java.util.Arrays;
import java.util.Scanner;

public class StringSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number of String :");
        int n = scanner.nextInt();
        String[] strings = new String[n];
        System.out.println("Enter the Strings");
       for (int i=0;i<n; i++){
           strings[i]= scanner.next();
       }
       Arrays.sort(strings);
        for (String s : strings){
            System.out.println(s);
        }
    }
}
