import java.util.*;
import java.text.*;


public class Cur{

  public static void main(String[] args){
   
  double val = 3.122322;


  NumberFormat cur = DecimalFormat.getCurrencyInstance();
  System.out.println(cur.format(val));




  }

}
