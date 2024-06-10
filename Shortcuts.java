//try lang ni-recycle ko lang yung sa pt natin da//ti
////
public class Shortcuts {
    static void clearScreen() throws InterruptedException{
        Thread.sleep(100);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean isAlphaNumeric(String in){
        String alphaChecker = "[a-zA-Z0-9]+( [a-zA-Z0-9]+)?";
        return in.matches(alphaChecker);
    }

    static boolean isAlphaNumericPassword(String input){
        String alphaChecker = "[a-zA-Z0-9]+";
        return input.matches(alphaChecker);
    }

    static boolean empty(String input) {
        return input.trim().isEmpty();
    }
}
