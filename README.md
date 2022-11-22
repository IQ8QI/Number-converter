# Number converter
Simple CLI tool to convert number between Roman and any other system number<br>
Supported number systems: binary, octal, decimal, hexadecimal, Roman and all other systems between 1 and 34<br>
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
