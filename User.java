public class User {
//test

    private String userId;
    private String name;
    private boolean isEligible;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
        this.isEligible = false;
    }
    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public boolean isEligible(){
        return isEligible;
    }
    public void setEligible(boolean isEligible){
        this.isEligible = isEligible;
    }

}
