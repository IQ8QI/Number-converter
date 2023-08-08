import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertTest {

    @Test
    @DisplayName("Testing Convert.romanToDecimal function")
    void testRomanToDecimal(){
        assertEquals("MMMCV", Convert.decimalToRoman(3105), "3105 should be converted to MMMCV");
        assertEquals("V", Convert.decimalToRoman(5), "5 should be converted to V");
        assertEquals("XXIV", Convert.decimalToRoman(24), "24 should be XXIV");
        assertEquals("LXXXIV", Convert.decimalToRoman(84), "84 should be converted to LXXXIV");
        assertEquals("CDLXIX", Convert.decimalToRoman(469), "469 should be converted to CDLXIX");
    }
}
