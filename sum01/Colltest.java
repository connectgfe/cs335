
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Colltest{

public static void main(String[] args){

/*
    Pokerhand jim= new Pokerhand();
    jim.gethand();

    Pokerhand steve=new Pokerhand();
    steve.gethand();
 

//    System.out.println(jim.compareTo(steve));

*/
 

    Pokerhand pair= new Pokerhand("2S","10C","3C","JD","10H");
    pair.gethand();

    Pokerhand khigh= new Pokerhand("7S","2C","8C","4D","KH");
    khigh.gethand();

    System.out.println("pair vs khigh "+pair.compareTo(khigh));


    Pokerhand twpair= new Pokerhand("3S","8C","3C","JD","8H");
    twpair.gethand();

    Pokerhand thknd= new Pokerhand("7S","7C","8C","4D","7H");
    thknd.gethand();

    System.out.println("twpair vs thknd "+twpair.compareTo(thknd));
 

    Pokerhand flhs= new Pokerhand("2S","8C","2C","8D","8H");
    flhs.gethand();

    Pokerhand frknd= new Pokerhand("7S","8C","8C","8D","8H");
    frknd.gethand();

    System.out.println("flhs vs frknd "+flhs.compareTo(frknd));


    Pokerhand flush= new Pokerhand("7S","8S","4S","2S","8S");
    flush.gethand();

    System.out.println("flhs vs flush "+flhs.compareTo(flush));


    Pokerhand strght=new Pokerhand("10H","JC","QS","8C","9H");

    System.out.println("flush vs strght "+flush.compareTo(strght));

    LinkedList<Pokerhand> games = new LinkedList<Pokerhand>();
    games.add(pair);
    games.add(strght);
    games.add(flush);
    games.add(thknd);
    games.add(twpair);
    games.add(khigh);
    games.add(flhs);
    games.add(frknd);

    for(int i=0;i<games.size();i++){
     System.out.println(games.get(i));
    }

    Collections.sort(games);

    for(int i=0;i<games.size();i++){
     System.out.println(games.get(i));
    }


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
