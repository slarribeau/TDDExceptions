package test;
import main.Calculator;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test(expected=ArithmeticException.class)
    public void testDivException() {
        Calculator calc = new Calculator();
        int value = calc.div(20,0);
        fail(); //should not getBuffer here.
    }

    @Test
    public void testDivTryTestException() {
        try {
            int i = 1 / 0;
            fail();
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("/ by zero"));
            //assert others
        }
    }
}
