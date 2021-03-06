

import java.util.*;
import model.PokerHand;
import model.Suit;
import model.Card;
import model.Rank;
import model.Azholdem;
import model.Player;


public class CollTest{


 public static void main(String[] args){

 Card C1 = new Card(Rank.DEUCE, Suit.CLUBS);
 Card C2 = new Card(Rank.THREE, Suit.HEARTS);
 Card C3 = new Card(Rank.NINE, Suit.CLUBS);
 Card C4 = new Card(Rank.FIVE, Suit.SPADES);
 Card C5 = new Card(Rank.NINE, Suit.SPADES);

 Card D1 = new Card(Rank.NINE, Suit.DIAMONDS);
 Card D2 = new Card(Rank.DEUCE, Suit.CLUBS);
 Card D3 = new Card(Rank.NINE, Suit.SPADES);
 Card D4 = new Card(Rank.FIVE, Suit.CLUBS);
 Card D5 = new Card(Rank.THREE, Suit.CLUBS);


  PokerHand one = new PokerHand(C1,C2,C3,C4,C5);

  PokerHand two = new PokerHand(D1,D2,D3,D4,D5);

  
 


  System.out.println(one.compareTo(two));

  LinkedList<PokerHand> best = new LinkedList<PokerHand>();
  best.add(one);
  best.add(two);



  Collections.sort(best);


  best.get(1).getHand();

/*
  LinkedList<Card> temp = new LinkedList<Card>();
  temp.add(C1);
  temp.add(C2);
  temp.add(C3);

  for(int i=0;i<temp.size();i++){
   System.out.print(temp.get(i).toString());
  }
  System.out.println();

  @SuppressWarnings("unchecked")
  LinkedList<Card> temp2 = (LinkedList<Card>)temp.clone();

  temp.remove(2);
  temp.remove(1);

  for(int i=0;i<temp.size();i++){
   System.out.print(temp.get(i).toString());
  }
  System.out.println();

  temp = temp2;

   for(int i=0;i<temp.size();i++){
   System.out.print(temp.get(i).toString());
  }
  System.out.println();


  
*/



 }



}

