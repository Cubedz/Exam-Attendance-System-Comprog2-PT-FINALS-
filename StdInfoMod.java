public class StdInfoMod {
    ///
//low
    private String studentId;
    private String name;
    private boolean isPaid;
   
    public StdInfoMod(String studentId, String name, boolean isPaid){
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
     
}
