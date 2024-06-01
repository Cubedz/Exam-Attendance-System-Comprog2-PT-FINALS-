import java.util.Scanner;

public class PaymentUpdater {
    public void UpdateandcheckPayStatus(User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Has student " + user.getName() + " (" + user.getUserId() + ") paid already? (Yes/No)");
        String ans = s.nextLine().trim().toLowerCase();

        if (ans.equals("yes")) {
            user.setEligible(true);
            System.out.println("Payment status updated. The student is eligible to take the exam.");
        } else {
            user.setEligible(false);
            System.out.println("The student is not eligible to take the exam.");
        }
    }


    
}
