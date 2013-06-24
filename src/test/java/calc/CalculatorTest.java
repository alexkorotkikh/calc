package calc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 6/22/13
 * Time: 10:20 AM
 */
@RunWith(Parameterized.class)
public class CalculatorTest {
    private final String strInput;
    private final int result;

    public CalculatorTest(final String strInput, final int result) {
        this.strInput = strInput;
        this.result = result;
    }

    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void testCalculate() throws Exception {
        assertEquals(result, calc.calculate(strInput));
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"1+1", 2},
                {"2 + 3", 5},
                {"10+ 1", 11},
                {"2 -5", -3},
                {"10 - 11", -1},
                {"1 - (2+3)", -4},
                {"(1+2)-4", -1},
                {"((1+2) + (3-4)) +8", 10}
        });
    }
}
