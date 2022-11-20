import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> parameters = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for(String arg : args)
            if(arg.charAt(0) == '-')
                parameters.add(arg);
            else
                values.add(arg);
        processInputs(parameters, values);
    }

    public static void processInputs(List<String> parameters, List<String> values){
        System.out.println("parameters" + parameters);
        System.out.println("values" + values);
    }

    public static int romanToDecimal(String roman){
        //I V X L C D M
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
                throw new InputMismatchException("Incorrect input at: " + roman.charAt(i-1) + "->" + roman.charAt(i) + "<-" + roman.charAt(i+1));
        }
        return -1;
    }

    public static String decimalToRoman(int decimal){
        return "work in progress";
    }
}