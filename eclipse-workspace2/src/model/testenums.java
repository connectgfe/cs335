//package model;
import java.util.*;



public class testenums{



  public static void main (String args[]){


  // straight flush A
  Card sfA1 = new Card(Rank.NINE,Suit.CLUBS);
  Card sfA2 = new Card(Rank.SIX, Suit.CLUBS);
  Card sfA3 = new Card(Rank.TEN, Suit.CLUBS);
  Card sfA4 = new Card(Rank.SEVEN, Suit.CLUBS);
  Card sfA5 = new Card(Rank.EIGHT, Suit.CLUBS);

  PokerHand strflA = new PokerHand(sfA1, sfA2, sfA3, sfA4, sfA5);
  
//  strflA.order();
  strflA.getHand();

  // straight flush B
  Card sfB1 = new Card(Rank.NINE,Suit.HEARTS);
  Card sfB2 = new Card(Rank.JACK, Suit.HEARTS);
  Card sfB3 = new Card(Rank.TEN, Suit.HEARTS);
  Card sfB4 = new Card(Rank.SEVEN, Suit.HEARTS);
  Card sfB5 = new Card(Rank.EIGHT, Suit.HEARTS);

  PokerHand strflB = new PokerHand(sfB1, sfB2, sfB3, sfB4, sfB5);
  
//  strflB.order();
  strflB.getHand();

  System.out.println("test strfl:(-1) "+strflA.compareTo(strflB));


  // straight  A
  Card sA1 = new Card(Rank.DEUCE,Suit.CLUBS);
  Card sA2 = new Card(Rank.FIVE, Suit.SPADES);
  Card sA3 = new Card(Rank.FOUR, Suit.CLUBS);
  Card sA4 = new Card(Rank.ACE, Suit.HEARTS);
  Card sA5 = new Card(Rank.THREE, Suit.CLUBS);

  PokerHand strA = new PokerHand(sA1, sA2, sA3, sA4, sA5);
  
//  strA.order();
  strA.getHand();

  // straight  B
  Card sB1 = new Card(Rank.NINE,Suit.DIAMONDS);
  Card sB2 = new Card(Rank.JACK, Suit.HEARTS);
  Card sB3 = new Card(Rank.TEN, Suit.HEARTS);
  Card sB4 = new Card(Rank.SEVEN, Suit.CLUBS);
  Card sB5 = new Card(Rank.EIGHT, Suit.HEARTS);

  PokerHand strB = new PokerHand(sB1, sB2, sB3, sB4, sB5);
  
//  strB.order();
  strB.getHand();

  System.out.println("test str:(-1) "+strA.compareTo(strB));



  // high card A
  Card hcA1 = new Card(Rank.NINE,Suit.HEARTS);
  Card hcA2 = new Card(Rank.ACE, Suit.CLUBS);
  Card hcA3 = new Card(Rank.FOUR, Suit.DIAMONDS);
  Card hcA4 = new Card(Rank.EIGHT, Suit.DIAMONDS);
  Card hcA5 = new Card(Rank.TEN, Suit.CLUBS);

  PokerHand hcrdA = new PokerHand(hcA1, hcA2, hcA3, hcA4, hcA5);
  
//  hcrdA.order();
  hcrdA.getHand();

  // high card B
  Card hcB1 = new Card(Rank.NINE,Suit.HEARTS);
  Card hcB2 = new Card(Rank.FOUR, Suit.CLUBS);
  Card hcB3 = new Card(Rank.TEN, Suit.DIAMONDS);
  Card hcB4 = new Card(Rank.EIGHT, Suit.DIAMONDS);
  Card hcB5 = new Card(Rank.ACE, Suit.CLUBS);

  PokerHand hcrdB = new PokerHand(hcB1, hcB2, hcB3, hcB4, hcB5);
 
//  hcrdB.order();
  hcrdB.getHand();

  System.out.println("test hcrd:(-1) "+hcrdB.compareTo(hcrdA));



  // flush A
  Card flA1 = new Card(Rank.NINE,Suit.CLUBS);
  Card flA2 = new Card(Rank.DEUCE, Suit.CLUBS);
  Card flA3 = new Card(Rank.TEN, Suit.CLUBS);
  Card flA4 = new Card(Rank.SEVEN, Suit.CLUBS);
  Card flA5 = new Card(Rank.JACK, Suit.CLUBS);

  PokerHand flushA = new PokerHand(flA1, flA2, flA3, flA4, flA5);
  
//  flushA.order();
  flushA.getHand();

  // flush B
  Card flB1 = new Card(Rank.FIVE,Suit.CLUBS);
  Card flB2 = new Card(Rank.DEUCE, Suit.CLUBS);
  Card flB3 = new Card(Rank.TEN, Suit.CLUBS);
  Card flB4 = new Card(Rank.ACE, Suit.CLUBS);
  Card flB5 = new Card(Rank.JACK, Suit.CLUBS);

  PokerHand flushB = new PokerHand(flB1, flB2, flB3, flB4, flB5);
  
//  flushB.order();
  flushB.getHand();

  System.out.println("test flush:(-1) "+flushA.compareTo(flushB));



  // full house A
  Card fhA1 = new Card(Rank.NINE,Suit.CLUBS);
  Card fhA2 = new Card(Rank.NINE, Suit.DIAMONDS);
  Card fhA3 = new Card(Rank.FOUR, Suit.SPADES);
  Card fhA4 = new Card(Rank.FOUR, Suit.CLUBS);
  Card fhA5 = new Card(Rank.NINE, Suit.HEARTS);

  PokerHand fulhsA = new PokerHand(fhA1, fhA2, fhA3, fhA4, fhA5);
  
//  fulhsA.order();
  fulhsA.getHand();

  // full house B
  Card fhB1 = new Card(Rank.DEUCE, Suit.CLUBS);
  Card fhB2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
  Card fhB3 = new Card(Rank.ACE, Suit.SPADES);
  Card fhB4 = new Card(Rank.ACE, Suit.CLUBS);
  Card fhB5 = new Card(Rank.ACE, Suit.HEARTS);

  PokerHand fulhsB = new PokerHand(fhB1, fhB2, fhB3, fhB4, fhB5);
  
//  fulhsB.order();
  fulhsB.getHand();

  System.out.println("test fulhs:(-1) "+fulhsA.compareTo(fulhsB));


  // 1 pair A
  Card prA1  = new Card(Rank.NINE,Suit.SPADES);
  Card prA2 = new Card(Rank.SIX, Suit.CLUBS);
  Card prA3 = new Card(Rank.NINE, Suit.CLUBS);
  Card prA4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  Card prA5 = new Card(Rank.EIGHT, Suit.CLUBS);

  PokerHand pairA = new PokerHand(prA1, prA2, prA3, prA4, prA5);
  
//  pairA.order();
  pairA.getHand();

  // 1 pair B
  Card prB1  = new Card(Rank.NINE,Suit.SPADES);
  Card prB2 = new Card(Rank.SIX, Suit.CLUBS);
  Card prB3 = new Card(Rank.JACK, Suit.CLUBS);
  Card prB4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  Card prB5 = new Card(Rank.JACK, Suit.CLUBS);

  PokerHand pairB = new PokerHand(prB1, prB2, prB3, prB4, prB5);
  
//  pairB.order();
  pairB.getHand();

  System.out.println("test pair:(-1) "+pairA.compareTo(pairB));



  // 2 pair A
  Card twprA1  = new Card(Rank.NINE,Suit.SPADES);
  Card twprA2 = new Card(Rank.SIX, Suit.CLUBS);
  Card twprA3 = new Card(Rank.NINE, Suit.CLUBS);
  Card twprA4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  Card twprA5 = new Card(Rank.SIX, Suit.HEARTS);

  PokerHand twpairA = new PokerHand(twprA1, twprA2, twprA3, twprA4, twprA5);
  
//  twpairA.order();
  twpairA.getHand();

  // 2 pair B
  Card twprB1  = new Card(Rank.NINE,Suit.SPADES);
  Card twprB2 = new Card(Rank.JACK, Suit.HEARTS);
  Card twprB3 = new Card(Rank.ACE, Suit.CLUBS);
  Card twprB4 = new Card(Rank.NINE, Suit.DIAMONDS);
  Card twprB5 = new Card(Rank.JACK, Suit.CLUBS);

  PokerHand twpairB = new PokerHand(twprB1, twprB2, twprB3, twprB4, twprB5);
  
//  twpairB.order();
  twpairB.getHand();

  System.out.println("test twpair:(-1) "+twpairA.compareTo(twpairB));



  // 3 kind A
  Card thrA1 = new Card(Rank.TEN,Suit.CLUBS);
  Card thrA2 = new Card(Rank.SIX, Suit.DIAMONDS);
  Card thrA3 = new Card(Rank.TEN, Suit.HEARTS);
  Card thrA4 = new Card(Rank.TEN, Suit.SPADES);
  Card thrA5 = new Card(Rank.EIGHT, Suit.CLUBS);

  PokerHand thrkndA = new PokerHand(thrA1, thrA2, thrA3, thrA4, thrA5);
  
//  thrkndA.order();
  thrkndA.getHand();

  // 3 kind B
  Card thrB1 = new Card(Rank.JACK,Suit.CLUBS);
  Card thrB2 = new Card(Rank.FOUR, Suit.DIAMONDS);
  Card thrB3 = new Card(Rank.JACK, Suit.HEARTS);
  Card thrB4 = new Card(Rank.TEN, Suit.SPADES);
  Card thrB5 = new Card(Rank.JACK, Suit.DIAMONDS);

  PokerHand thrkndB = new PokerHand(thrB1, thrB2, thrB3, thrB4, thrB5);
  
//  thrkndB.order();
  thrkndB.getHand();

  System.out.println("test thrknd:(-1) "+thrkndA.compareTo(thrkndB));


  // 4 kind A
  Card frA1 = new Card(Rank.FOUR,Suit.CLUBS);
  Card frA2 = new Card(Rank.JACK, Suit.SPADES);
  Card frA3 = new Card(Rank.FOUR, Suit.HEARTS);
  Card frA4 = new Card(Rank.FOUR, Suit.SPADES);
  Card frA5 = new Card(Rank.FOUR, Suit.DIAMONDS);

  PokerHand fourkndA = new PokerHand(frA1, frA2, frA3, frA4, frA5);
  
//  fourkndA.order();
  fourkndA.getHand();

  // 4 kind B
  Card frB1 = new Card(Rank.JACK,Suit.CLUBS);
  Card frB2 = new Card(Rank.JACK, Suit.SPADES);
  Card frB3 = new Card(Rank.JACK, Suit.HEARTS);
  Card frB4 = new Card(Rank.TEN, Suit.SPADES);
  Card frB5 = new Card(Rank.JACK, Suit.DIAMONDS);

  PokerHand fourkndB = new PokerHand(frB1, frB2, frB3, frB4, frB5);
  
//  fourkndB.order();
  fourkndB.getHand();

  System.out.println("test fourknd:(-1) "+fourkndA.compareTo(fourkndB));



  LinkedList<PokerHand> best = new LinkedList<PokerHand>();

  best.add(strflA);
  best.add(strflB);
  best.add(strA);
  best.add(strB);
  best.add(hcrdA);
  best.add(hcrdB);
  best.add(flushA);
  best.add(flushB);
  best.add(fulhsA);
  best.add(fulhsB);
  best.add(pairA);
  best.add(pairB);
  best.add(twpairA);
  best.add(twpairB);
  best.add(thrkndA);
  best.add(thrkndB);
  best.add(fourkndA);
  best.add(fourkndB);

  for(int i=0;i<18;i++){

    best.get(i).getHand();

  }


  Collections.sort(best);


  for(int i=0;i<18;i++){

    best.get(i).getHand();

  }
  
 }



}
