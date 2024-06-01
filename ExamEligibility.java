public class ExamEligibility {

        public static void main(String[] args) {
            User user = new User());
            PaymentUpdater pu = new PaymentUpdater();
    
            pu.UpdateandcheckPayStatus(user);
    
            if (user.isEligible()) {
                System.out.println("User " + user.getName() + " (" + user.getUserId() + ") is eligible to take the exam.");
            } else {
                System.out.println("User " + user.getName() + " (" + user.getUserId() + ") is not eligible to take the exam. Payment is required.");
            }
        }
    }