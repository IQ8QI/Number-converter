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
    }
}
