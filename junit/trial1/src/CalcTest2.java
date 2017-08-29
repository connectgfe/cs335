import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcTest2 {
  @Test
  public void evaluatesExpression() {
    Calc calculator = new Calc();
    int sum = calculator.evaluate("1+2+3");
    assertEquals(6, sum);
  }
}
