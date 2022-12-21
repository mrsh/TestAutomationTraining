import com.altkom.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;
    private final int x = 8;
    private final int y = 3;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator(x,y);
    }

    @Test
    public void sumTest() {
//        Calculator calculator = new Calculator(2,6);
        Assert.assertEquals(calculator.calculateSum(),x+y);
    }

    @Test
    public void distinctionTest() {
//        Calculator calculator = new Calculator(5,3);
        Assert.assertEquals(calculator.calculateDistinction(), x-y);
    }
}
