import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("Testing Main.main")
    void testMain(){
        System.out.print("expected 4L2 received ");
        Main.main(new String[]{"-4", "-22", "211200"});

        System.out.print("expected 3X1 received ");
        Main.main(new String[]{"-9", "-34", "6261"});

        System.out.print("expected 110 received ");
        Main.main(new String[]{"-7", "-10", "215"});
    }
}

