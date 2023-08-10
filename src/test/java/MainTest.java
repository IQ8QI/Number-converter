import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

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


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}

