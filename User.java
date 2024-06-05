<<<<<<< HEAD
public class User {

 private String studentId;
 private String name;
 private boolean isPaid;

 public User(String studentId, String name, boolean isPaid){
    this.studentId = studentId;
    this.name = name;
    this.isPaid = isPaid;
 }
 public String getstudentId(){
    return studentId;
 }
 public String getName(){
    return name;
 }
 public boolean isPaid(){
    return isPaid;
 }
 public boolean isEligible(){
    return isPaid;
  }
  
=======
public class User 
{
   private String username, password, studentID, studentName;


   public String getUsername()
   {
      return this.username = username;
   }
   public void setUsername(String username)
   {
      this.username = username;
   }
   public String getPassword()
   {
      return this.password = password;
   }
   public void setPassword(String password)
   {
      this.password = password;
   }
   public String getStudentID()
   {
      return studentID;
   }
   public void setStudentID(String studentID)
   {
      this.studentID = studentID;
   }
   public String getStudentName()
   {
      return studentName;
   }
   public void setStudentName(String studentName)
   {
      this.studentName = studentName;
   }

>>>>>>> 59cb7bc9fb6c5916d2f8cac7edc7608203f4a8b6
}