package trustrace;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static String search(int[] a,int key){

        int start = 0,end =a.length,middle;
        while(start<=end){
            middle=(start+end)/2;
            if(a[middle]==key)
                return "Found at index: "+middle;
            else if(a[middle] < key)
                start=middle+1;
            else
                end = middle-1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int arraySize = scanner.nextInt();
        System.out.println("Enter the Array Elements");
        int[] arr = new int[arraySize];
        for (int i = 0;i < arraySize;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.print("Enter the Elements to Search: ");
        int searchElement = scanner.nextInt();
        System.out.println(search(arr,searchElement));
    }
}
