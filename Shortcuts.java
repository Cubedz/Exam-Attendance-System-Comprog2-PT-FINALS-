//try lang ni-recycle ko lang yung sa pt natin dati

public class Shortcuts {
    static void clearScreen() throws InterruptedException{
        Thread.sleep(2000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean isAlphaOnly(String in){
        String alphaChecker = "[a-zA-Z]+( [a-zA-Z]+)?";
        return in.matches(alphaChecker);
    }

    static boolean isNumericID(String input){
        String alphaChecker = "[0-9]{11}";
        return input.matches(alphaChecker);
    }

    static boolean empty(String input) {
        return input.trim().isEmpty();
    }
}
