import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * First divide inputs for parameters and values and store them in separate lists
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

        processInputs(parameters, values);
    }

    public static void processInputs(List<String> parameters, List<String> values){
        /**
         * Dispaly help if input is incorrect
         * or if user asks for help
         */
        if(parameters.isEmpty() || parameters.get(0).charAt(0) == 'H' || parameters.get(0).charAt(0) == '?')
            displayManual();

        /**
         * Set input system and ouput system
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
        else if(parameters.get(0).charAt(0) == 'H')
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
        else if(parameters.get(1).charAt(0) == 'H')
            outputSystem = 16;
        else
            outputSystem = Integer.parseInt(parameters.get(1));

        System.out.println("parameters" + parameters);
        System.out.println("values" + values);
        System.out.println(changeNumberSystem(Integer.parseInt(values.get(0)), inputSystem, outputSystem));

    }

    /**
     * Function translates number from roman system to decimal system
     * @param roman number to be translated
     * @return Intiger translated from roman number
     */
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

    /**
     * Function translates number from decimal systemto romrna system
     * @param decimal number to be translated
     * @return String roman number
     */
    public static String decimalToRoman(int decimal){
        return "work in progress";
    }

    /**
     * Function translates number from inputSystem to outputSystem
     * @param input number to be translated given in inputSystem
     * @param inputSystem system of number to be translated from
     * @param outputSystem system of number to be translated to
     * @return ouputs result of the translation as String
     */
    public static String changeNumberSystem(int input, int inputSystem, int outputSystem){
        return "work in progress";
    }

    /**
     * Display manual for user and exit, same as README.md
     */
    public static void displayManual(){
        System.out.println("""
                # Number converter
                Simple CLI tool to convert number between Roman and any other system number
                Supported number systems: binary, octal, decimal, hexadecimal, Roman and all other systems between 1 and 34
                Roman numbers supported only between 1 and 3999
                                
                # Usage
                    numconv [input system] [output system] [input number]
                                
                # Examples
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
        System.exit(0);
    }
}