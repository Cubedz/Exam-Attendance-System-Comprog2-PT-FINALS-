public class User {
////
   private static String username;
   private static String password;
   private static String studentID;
   private static String studentName;
//
   public static String getUsername() {

       return username;
   }

   public static void setUsername(String username) {

       User.username = username;
   }

   public static String getPassword() {

       return password;
   }

   public static void setPassword(String password) {
  
       User.password = password;
   }

   public static String getStudentID() {
    
       return studentID;
   }

   public static String setStudentID(String student_id) {
    
       return User.studentID = student_id;
   }

   public static String getStudentName() {

       return studentName;
   }

   public static String setStudentName(String student_name) {

       return User.studentName = student_name;
   }

}