
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Colltest{

public static void main(String[] args){


    Pokerhand jim= new Pokerhand();
    jim.gethand();

    Pokerhand steve=new Pokerhand();
    steve.gethand();
 

    System.out.println(jim.compareTo(steve));
   
//    System.out.println(jim.fourkind());

/*

    LinkedList<Card> phil = new LinkedList<Card>();
    Deck no1 = new Deck();
    no1.deal2(phil);

    for(int i=0;i<5;i++){

    System.out.println(phil.get(i)+" "+phil.get(i).rank);

    }

 
    System.out.println(Collections.min(phil));

    Collections.sort(phil);

    for(int i=0;i<5;i++){

    System.out.println(phil.get(i)+" "+phil.get(i).rank);

    }

*/


 }

}






/*
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
*/
