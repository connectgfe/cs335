
public class testjava{

  public static void main(String[] args){

  Deck deck1=new Deck();
  Player John= new Player("John");
  deck1.deal(John);
  Player Steve= new Player("Steve");
  deck1.deal(Steve);
  Cardgame first=new Cardgame(John,Steve);
  first.showhands();

//  John.gethand();
  }
}
