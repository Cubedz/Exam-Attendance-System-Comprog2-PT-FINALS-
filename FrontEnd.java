/* 

import java.util.Scanner;

public class FrontEnd {

    private static final Scanner sc = new Scanner(System.in);
    
        public void runProgram(){
    
            while (true){
                try{
                    System.out.println("------------------------------------------");
                    System.out.println("|WELCOME ADMIN! Enter Username & Password|");
                    System.out.println("------------------------------------------");
                    String choice = sc.nextLine();
    
                    if(choice.equalsIgnoreCase("R")){
                        Thread.sleep(500);
                        System.out.print("\033[H\033[2J"); 
                        Register.register();
                        
                    }else if(choice.equalsIgnoreCase("L")){
                        shortCut.clearScreen();
                        Login.login();
                        break;
                    }else if(choice.equalsIgnoreCase("X")){
                        System.out.println("Thank you for using our porgram");
                             shortCut.clearScreen();
                             break;
                    }else{
                        System.out.println("Invalid choice. Please try again");
                            shortCut.clearScreen();
                    }
                }catch (Exception e){
                    System.out.println("Message: " + e);
                }
            }
        }
    
} 
*/