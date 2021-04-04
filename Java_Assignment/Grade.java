package trustrace;

import  java.util.Scanner;
public class Grade {

     static char gradeCalculate(int mark){
        return mark>=80 ? 'A' : mark>=60 ? 'B' : mark >= 40 ? 'C' : 'D';
    }

    public static void main(String[] args) {

         int numberOfSubjects,totalMarks=0,average;
         Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Subjects:");
         numberOfSubjects = scanner.nextInt();
        int[] subjects = new int[numberOfSubjects];
        System.out.println("Enter marks of each subjects:");
        for (int sub:subjects){
            subjects[sub] = scanner.nextInt();
            totalMarks+=subjects[sub];
        }
         average = totalMarks/numberOfSubjects;
        System.out.println("Grade: "+gradeCalculate(average));

        
    }
}
