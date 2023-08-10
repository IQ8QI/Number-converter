import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConvertTest {

    @Test
    @DisplayName("Testing Convert.decimalToRoman function")
    void testDecimalToRoman(){
        assertEquals("MMMCV", Convert.decimalToRoman(3105), "3105 should be converted to MMMCV");
        assertEquals("V", Convert.decimalToRoman(5), "5 should be converted to V");
        assertEquals("XXIV", Convert.decimalToRoman(24), "24 should be XXIV");
        assertEquals("LXXXIV", Convert.decimalToRoman(84), "84 should be converted to LXXXIV");
        assertEquals("CDLXIX", Convert.decimalToRoman(469), "469 should be converted to CDLXIX");
        assertThrows(InputMismatchException.class, () -> Convert.decimalToRoman(4000), "4000 is to big for program to convert");
        assertThrows(InputMismatchException.class, () -> Convert.decimalToRoman(0), "0 is to small to be converted");
    }

    @Test
    @DisplayName("Testing Convert.romanToDecimal function")
    void testRomanToDecimal(){
        assertEquals(2485, Convert.romanToDecimal("MMCDLXXXV"), "MMCDLXXXV should be converted to 2485");
        assertEquals(3999, Convert.romanToDecimal("MMMCMXCIX"), "MMMCMXCIX should be converted to 3999");
        assertEquals(1, Convert.romanToDecimal("I"), "I should be converted to 1");
        assertEquals(249, Convert.romanToDecimal("CCXLIX"), "CCXLIX should be converted to 249");
        assertThrows(InputMismatchException.class, () -> Convert.romanToDecimal("MMMM"), "Number MMMM is to big to be converted");
        assertThrows(InputMismatchException.class, () -> Convert.romanToDecimal("CCH"), "H is not part of Roman system");
        assertThrows(InputMismatchException.class, () -> Convert.romanToDecimal("XX1"), "1 is not part of Roman system");
    }

    @Test
    @DisplayName("Testing Convert.inputStringToArrayList")
    void testInputStringToArrayList(){
        assertEquals(Arrays.asList(2,3,13,1,17), Convert.inputStringToArrayList("23D1H"), "23D1H should be converted to (2,3,13,1,17)");
        assertEquals(Arrays.asList(0,1,2,3,4,5,6,7,8,9), Convert.inputStringToArrayList("0123456789"), "");
        assertEquals(Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35), Convert.inputStringToArrayList("abcdefghijklmnopqrstuvwxyz"), "abcdefghijklmnopqrstuwxyz should be converted to (10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33)");
        assertEquals(Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35), Convert.inputStringToArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), "ABCDEFGHIJKLMNOPQRSTUWXYZ should be converted to (10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33)");
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList(""));
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList("'"));
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList("["));
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList(")"));
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList("\n"));
        assertThrows(InputMismatchException.class, () -> Convert.inputStringToArrayList("%"));
    }

    @Test
    @DisplayName("Testing Convert.arrayListToInputString")
    void testArrayListToInputString(){
        assertEquals("0123456789", Convert.arrayListToInputString(Arrays.asList(0,1,2,3,4,5,6,7,8,9)));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Convert.arrayListToInputString(Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35)), "(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33) should be converted to ABCDEFGHIJKLMNOPQRSTUWXYZ");
        assertThrows(InputMismatchException.class, () -> Convert.arrayListToInputString(Arrays.asList(25, -5, 7)));
        assertThrows(InputMismatchException.class, () -> Convert.arrayListToInputString(Arrays.asList(5,9,15,30,98,2)));
    }

    @Test
    @DisplayName("Testing Convert.nonRomanToDecimal")
    void testNonRomanToDecimal(){
        assertEquals(2400, Convert.nonRomanToDecimal(Arrays.asList(2,1,1,2,0,0), 4), "4-base 211200 is 10-base 2400");
        assertEquals(4591, Convert.nonRomanToDecimal(Arrays.asList(6,2,6,1), 9), "9-base 6261 is 10-base 4591");
        assertEquals(109, Convert.nonRomanToDecimal(Arrays.asList(7, 11), 14), "14-base 7B is 10-base 109");
        assertEquals(2400, Convert.nonRomanToDecimal(Arrays.asList(4, 21, 2), 22), "22-base 4L2 is 10-base 2400");
        assertEquals(4591, Convert.nonRomanToDecimal(Arrays.asList(3, 33, 1), 34), "34-base 3X1 is 10-base 4591");
        assertEquals( 6, Convert.nonRomanToDecimal(Arrays.asList(0,0,0,0,0,0,0), 1), "1-base 0000000 is 10-base 6");
        assertThrows(InputMismatchException.class, () -> Convert.nonRomanToDecimal(Arrays.asList(1, 6, 8), 0));
        assertThrows(InputMismatchException.class, () -> Convert.nonRomanToDecimal(Arrays.asList(2, 6, 10), 40));
        assertThrows(InputMismatchException.class, () -> Convert.nonRomanToDecimal(Arrays.asList(2, 6, 10), 10));
        assertThrows(InputMismatchException.class, () -> Convert.nonRomanToDecimal(Arrays.asList(35, 29, 4, 7, 16), 34));
        assertThrows(InputMismatchException.class, () -> Convert.nonRomanToDecimal(Arrays.asList(9, 4, 31, -5, 15), 32));
    }

    @Test
    @DisplayName("Testing Convert.decimalToNonRoman")
    void testDecimalToNonRoman(){
        assertEquals(Arrays.asList(6,2,6,1), Convert.decimalToNonRoman(4591, 9), "10-base 4591 is 9-base 6261");
        assertEquals(Arrays.asList(2,1,1,3,1,0), Convert.decimalToNonRoman(2420, 4), "10-base 2420 is 4-base 211200");
        assertEquals(Arrays.asList(2,1,5), Convert.decimalToNonRoman(110, 7), "10-base 110 is 7-base 215");
        assertEquals(Arrays.asList(4,0,1), Convert.decimalToNonRoman(4625, 34), "10-base 4625 is 34-base 401");
        assertEquals(Arrays.asList(3,33,1), Convert.decimalToNonRoman(4591, 34), "10-base 4591 is 34-base 3X1");
        assertThrows(InputMismatchException.class, () -> Convert.decimalToNonRoman(5148, 0));
        assertThrows(InputMismatchException.class, () -> Convert.decimalToNonRoman(9456, 37));
        assertThrows(InputMismatchException.class, () -> Convert.decimalToNonRoman(51, -4));
    }
}
