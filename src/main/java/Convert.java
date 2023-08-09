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
            if(result > 3999){
                throw new InputMismatchException("Can't convert number above 3999");
            }
        }
        return result;
    }

    /**
     * Function translates number from decimal system to roman system
     * @param decimal Integer number to be translated
     * @return String roman number
     */
    public static String decimalToRoman(int decimal){
        if(decimal < 1 || decimal > 3999)
            throw new InputMismatchException("Unable to convert " + decimal + " to Roman number system");

        StringBuilder builder = new StringBuilder();
        while(decimal > 0){
            if(decimal >= 1000) {
                builder.append('M');
                decimal -= 1000;
            } else if(decimal >= 900){
                builder.append("CM");
                decimal -= 900;
            } else if(decimal >= 500){
                builder.append('D');
                decimal -= 500;
            } else if(decimal >= 400){
                builder.append("CD");
                decimal -= 400;
            } else if(decimal >= 100) {
                builder.append('C');
                decimal -= 100;
            } else if(decimal >= 90){
                builder.append("XC");
                decimal -= 90;
            } else if(decimal >= 50){
                builder.append('L');
                decimal -= 50;
            } else if(decimal >= 40){
                builder.append("XL");
                decimal -= 40;
            } else if(decimal >= 10){
                builder.append('X');
                decimal -= 10;
            } else if(decimal >= 9){
                builder.append("IX");
                decimal -= 9;
            } else if(decimal >= 5){
                builder.append('V');
                decimal -= 5;
            } else if(decimal >= 4){
                builder.append("IV");
                decimal -= 4;
            } else {
                builder.append('I');
                decimal--;
            }
        }
        return builder.toString();
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

    /**
     * Translates List<Integer> into a String.
     * Numbers above 9 becomes letters starting at A.
     * For example [2, 3, 14, 1, 18] -> "23D1H".
     * Throws InputMismatchException if number is 34 or bigger.
     * @param inputList list of integers to be translated into string, value cannot exceed 33
     * @return string expressing values from list
     */
    public static String arrayListToInputString(List<Integer> inputList){
        StringBuilder builder = new StringBuilder();
        for(Integer i : inputList){
            if(i >= 0 && i <= 9){
                builder.append(i);
            } else if(i <= 34){
                builder.append(ascii_A + i - 10);
            } else {
                throw new InputMismatchException(i + " is not a valid number");
            }
        }
        return builder.toString();
    }

    /**
     * Function translates number from non-Roman number system to decimal system.
     * @param inputList List<Integer> containing values of consequent numbers before translation.
     * @param inputSystem Integer 1 - 34 symbolizing the base of number.
     * @return Integer with value of number after conversion.
     */
    public static int nonRomanToDecimal(List<Integer> inputList, int inputSystem){
        if(inputSystem < 1 || inputSystem > 34)
            throw new InputMismatchException("Impossible to translate number from " + inputSystem + "-base system");

        int result = 0;
        int size = inputList.size();
        for(int i = size - 1; i >= 0; i--){
            result += inputList.get(i) * Math.pow(inputSystem, size - i - 1);
        }
        return result;
    }

    /**
     * Function translates integer number from decimal, or base-10, number system,
     * into new number with outputSystem-base system.
     * @param inputValue decimal integer to be translated.
     * @param outputSystem type of result number base system. Legal values 1-34.
     * @return ArrayList<Integer> with continuous digits
     */
    public static List<Integer> decimalToNonRoman(int inputValue, int outputSystem){
        if(outputSystem < 1 || outputSystem > 34)
            throw new InputMismatchException("Impossible to translate number to " + outputSystem + "-base system");

        List<Integer> result = new ArrayList<>();
        while(inputValue != 0){
            result.add(inputValue % outputSystem);
            inputValue /= outputSystem;
        }

        int size = result.size();
        int tmp;
        for(int i = 0; i < size / 2; i++){
            tmp = result.get(i);
            result.set(i, result.get(size - i - 1));
            result.set(size - i - 1, tmp);
        }

        return result;
    }
}
