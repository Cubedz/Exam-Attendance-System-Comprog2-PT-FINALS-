import java.util.*;
public class ExamAttendanceSystem {

/*Admin Log-in
 * Once logged in, get student info
 * display if student is eligible for exam
 * if eligible, record their attendance
 * then ask the next student for their ID and Name
 * continue the program once all students have been recorded
 */

//Front End prototype
 public static void main(String[] args) {
    String a;
    String b;
    String c;
    String d;

    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome Admin");
    System.out.println("Enter you username: ");
    a = sc.nextLine();
    System.out.println("Enter your password");
    b = sc.nextLine();

    System.out.println("Succesfully loggged in");

    System.out.println("Enter student id: ");
    c = sc.nextLine();

    System.out.println("Enter name: ");
    d = sc.nextLine();

    //method to check if paid or not
    //IF student is paid, the program will mark the student as ATTENDED
    //the program will repeat for the next student to enter their attendance
    //the program will say if ALL students havce been recorded for that section

 }
}
