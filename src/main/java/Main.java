import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Divide inputs for parameters and values and store them in separate lists
         * All parameters and values are in upper case
         */
        for(int i = 0; i < args.length; i++)
            args[i] = args[i].toUpperCase();

        List<String> parameters = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for(String arg : args)
            if(arg.charAt(0) == '-')
                parameters.add(arg.replace("-", ""));
            else
                values.add(arg);

        /*
         * Display help if input is empty or user asks for help
         */
        if(parameters.isEmpty() || values.isEmpty() || parameters.get(0).charAt(0) == 'H' || parameters.get(0).charAt(0) == '?')
            displayManual(-1);

        /*
         * Set input system and output system
         */
        int inputSystem;
        int outputSystem;

        if(parameters.get(0).charAt(0) == 'R')
            inputSystem = 0;
        else if(parameters.get(0).charAt(0) == 'B')
            inputSystem = 2;
        else if(parameters.get(0).charAt(0) == 'O')
            inputSystem = 8;
        else if(parameters.get(0).charAt(0) == 'D')
            inputSystem = 10;
        else if(parameters.get(0).charAt(0) == 'X')
            inputSystem = 16;
        else
            inputSystem = Integer.parseInt(parameters.get(0));

        if(parameters.get(1).charAt(0) == 'R')
            outputSystem = 0;
        else if(parameters.get(1).charAt(0) == 'B')
            outputSystem = 2;
        else if(parameters.get(1).charAt(0) == 'O')
            outputSystem = 8;
        else if(parameters.get(1).charAt(0) == 'D')
            outputSystem = 10;
        else if(parameters.get(1).charAt(0) == 'X')
            outputSystem = 16;
        else
            outputSystem = Integer.parseInt(parameters.get(1));

    /*
     * Decide witch conversion methods to use, in order to convert the number
     * from given inputSystem to given outputSystem.
     */

        if(inputSystem == outputSystem) {
            System.out.println(values.get(0));
            System.exit(0);
        }

        int value;
        if(inputSystem == 0){
            value = Convert.romanToDecimal(values.get(0));
        } else {
            value = Convert.nonRomanToDecimal(Convert.inputStringToArrayList(values.get(0)), inputSystem);
        }
        if(outputSystem == 0){
            System.out.println(Convert.decimalToRoman(value));
        } else {
            System.out.println(Convert.arrayListToInputString(Convert.decimalToNonRoman(value, outputSystem)));
        }
    }

    /**
     * Display manual for user and exit, same as README.md
     */
    public static void displayManual(int status){
        System.out.println("""
                # Number converter
                Simple CLI tool to convert number between Roman and any other system number<br>
                Supported number systems: binary, octal, decimal, hexadecimal, Roman and all other systems between 1 and 36<br>
                Roman numbers supported only between 1 and 3999
                                
                ## Usage
                    numconv [input system] [output system] [input number]
                    numconv [input system] [input number] [output system]
                    numconv [input number] [input system] [output system]


                ### Supported bases shortcuts
                binary `-b --binary`\\
                octal `-o --octal`\\
                decimal `-d --decimal`\\
                hexadecimal `-x --hexadecimal`

                ## Examples
                Convert Roman number to decimal

                    numconv -r MMMCV -10
                    numconv --roman --decimal CCVI

                Convert octal number to Roman

                    numconv --octal --roman 45613752
                    numconv 456103752 -8 -r

                Convert decimal number to Roman

                    numconv --decimal --roman 3420
                    numconv -10 -r 14

                Convert 17 based system number to 4 based system number

                    numconv -17 43g9a3 -4
                    numconv 938e7c2b --17 -4

                Convert 5 based system number to 34 based system number

                    numconv --5 --34 12342242342
                    numconv 40441232441 -5 -34

                Display help

                    numconv
                    numconv ?
                    numconv --help
                    numconv -h
                """);
        System.exit(status);
    }
}