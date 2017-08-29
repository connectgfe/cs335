//package tests;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.Calc2;

public class CalcTest {
  @Test
  public void evaluatesExpression() {
    Calc2 calculator = new Calc2();
    int sum = calculator.evaluate("1+2+3");
    assertEquals(6, sum);
  }
}
