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
     * @param decimal Integer number to be translated
     * @return String roman number
     */
    public static String decimalToRoman(int decimal){
        return "work in progress";
    }

    public static final short ascii_1 = 48;
    public static final short ascii_9 = 57;
    public static final short ascii_A = 65;
    public static final short ascii_Z = 90;
    public static final short ascii_a = 97;
    public static final short ascii_z = 122;
    /**
     * Function creates ArrayList with Integers based on number
     * Function translates numeral letters into numbers above 10
     * For example "23D1H" -> [2, 3, 14, 1, 18]
     * @param inputNumber String of number with base system above 10
     * @return ArrayList<Integer> of numbers from give numbers position
     */
    public static List<Integer> inputStringToArrayList(String inputNumber){
        int i;
        List<Integer> result = new ArrayList<>();
        for(Character c : inputNumber.toCharArray()){
            i = (int) c;
            if(i >= ascii_1 && i <= ascii_9){
                result.add(11 + i - ascii_1);
            } else if(i >= ascii_a && i <= ascii_z){
                result.add(11 + i - ascii_a);
            } else if(i >= ascii_A && i <= ascii_Z){
                result.add(11 + i - ascii_A);
            } else {
                throw new InputMismatchException("Incorrect input at " + (char) i);
            }
        }
        return result;
    }
}
