import java.util.*;


public class TemperatureConverter { 

  // Return the Celsius equivalent of Fahrenheit
  public static double FtoC(double f) {
    return roundToOneDecimal((5.0 / 9.0) * (f - 32.0));
  } 

  // Return the Fahrenheit equivalent of Celsius
  public static double CtoF(double c) {
    return roundToOneDecimal((9.0 / 5.0) * c + 32.0);
  }

  private static double roundToOneDecimal(double number) { 
    return Math.round(number * 10) / 10.0;
  }

}
