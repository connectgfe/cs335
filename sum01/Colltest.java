
import java.util.Collection;
import java.util.LinkedList;

public class Colltest{

public static void main(String[] args){

   Comptest test=new Comptest();



 }

}







class Comptest{

  Collection<Card> testc;

  LinkedList<Card> deck01 = new LinkedList<Card>();

  public Comptest(){

  for(int i=0;i<5;i++){
    Card next=new Card(Integer.toString(i),"V");
    deck01.add(i,next);
   }  

  }
}
