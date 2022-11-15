import java.util.*;

public class Main {
    public static void main(String[] args) {
        //I V X L C D M
        List<String> parameters = new ArrayList<>();
        for(String arg : args){
            if(arg.charAt(0) == '-') {
                parameters.add(arg);
            }
        }
    }

    public static int RomanToDecimal(String roman){
        roman = roman.toUpperCase();
        List<Character> correctInputChars = new ArrayList<>();
        //char[] correctInputChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        correctInputChars.add('I');
        correctInputChars.add('V');
        correctInputChars.add('X');
        correctInputChars.add('L');
        correctInputChars.add('C');
        correctInputChars.add('D');
        correctInputChars.add('M');
        int result = 0;
        int len = roman.length();
        for(int i = len - 1; i >= 0; i--){
            if(!correctInputChars.contains(roman.charAt(i)))
                throw new InputMismatchException("Incorrect input at: " + roman.charAt(i));
        }
        return 0;
    }
}