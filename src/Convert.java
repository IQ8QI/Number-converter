import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Convert {

    /**
     * Function treats input string as Roman number and
     * translates it to decimal number
     * @param input value to be converted
     * @return integer value after conversion
     */
    public static int romanToDecimal(String input) {
        input = input.toUpperCase();
        List<Character> correctInputChars = new ArrayList<>();
        correctInputChars.add('I');
        correctInputChars.add('V');
        correctInputChars.add('X');
        correctInputChars.add('L');
        correctInputChars.add('C');
        correctInputChars.add('D');
        correctInputChars.add('M');
        for(int i = 0; i < input.length(); i++){
            if(!correctInputChars.contains(input.charAt(i)))
                throw new InputMismatchException("Incorrect input at: " + input.charAt(i-1) + "->" + input.charAt(i) + "<-" + input.charAt(i+1));
        }


        int result = 0;
        int i = input.length() - 1;
        boolean check = true;
        while(i >= 0){
            if(i < 1) check = false;
            if(input.charAt(i) == 'I'){
                result += 1;
            } else if(input.charAt(i) == 'V') {
                if(!check){
                    result += 5;
                } else if(input.charAt(i - 1) == 'I'){
                    result += 4;
                    i--;
                } else {
                    result += 5;
                }
            } else if(input.charAt(i) == 'X') {
                if(!check){
                    result += 10;
                } else if(input.charAt(i - 1) == 'I'){
                    result += 9;
                    i--;
                } else {
                    result += 10;
                }
            } else if(input.charAt(i) == 'L') {
                if(!check){
                    result += 50;
                } else if(input.charAt(i - 1) == 'X'){
                    result += 40;
                    i--;
                } else {
                    result += 50;
                }
            } else if(input.charAt(i) == 'C') {
                if(!check){
                    result += 100;
                } else if(input.charAt(i - 1) == 'X'){
                    result += 90;
                    i--;
                } else {
                    result += 100;
                }
            } else if(input.charAt(i) == 'D') {
                if(!check){
                    result += 500;
                } else if(input.charAt(i - 1) == 'C'){
                    result += 400;
                    i--;
                } else {
                    result += 500;
                }
            } else if(input.charAt(i) == 'M') {
                if(!check){
                    result += 1000;
                } else if(input.charAt(i - 1) == 'C'){
                    result += 900;
                    i--;
                } else {
                    result += 1000;
                }
            }
            i--;
        }
        return result;
    }

    /**
     * Function translates number from decimal system to roman system
     * @param decimal number to be translated
     * @return String roman number
     */
    public static String decimalToRoman(int decimal){
        return "work in progress";
    }
}
