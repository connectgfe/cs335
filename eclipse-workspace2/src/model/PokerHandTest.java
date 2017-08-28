package tests;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.DuplicateCardException;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the PokerHand class and the enums 
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test methods)
 * 
 * There are also some additional test cases here. However this unit test is in no way
 * complete since many more @Tests (test cases) are needed.   
 * 
 * Since PokerHand is not complete, all of the @Tests comparing PokerHand objects should fail.
 * 
 * The include enums Suit and Rank @Tests should pass since both enums are complete
*/
public class PokerHandTest {

  @Test
  public void testSuitEnum() {
    String result = "";
    for (Suit suit : Suit.values())
      result += suit + " ";
    assertEquals("CLUBS DIAMONDS HEARTS SPADES", result.trim());
  }

  @Test
  public void testRankEnum() {
    String result = "";
    for (Rank rank : Rank.values())
      result += rank + " ";
    assertEquals("DEUCE THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE",
        result.trim());
  }

  // Do not allow duplicate cards, throw an exception
  @Test(expected = DuplicateCardException.class)
  public void tryToAddTheSameCardTwiceA() {
    new PokerHand(C2, C3, C4, C5, C5);
  }

  @Test(expected = DuplicateCardException.class)
  public void testPair2() {
    PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
    a.toString();
    PokerHand b = new PokerHand(H3, C5, HA, SA, C6);
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void testTwoPairWhenOnePairIsEqual() {
    PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
    PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testAceLowStraight() {
    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
    PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
    boolean answer = a.compareTo(b) < 0;
    assertTrue(answer);
  }

  // Set up 52 cards to use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
  private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
  private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
  private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
  private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
  private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
  private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
  private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
  private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
  private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
  private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
  private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
  private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
  private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

  private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
  private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
  private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
  private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
  private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
  private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
  private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
  private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
  private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
  private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
  private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
  private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

  private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
  private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
  private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
  private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
  private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
  private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
  private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
  private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
  private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
  private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
  private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
  private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
  private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

  private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
  private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
  private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
  private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
  private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
  private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
  private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
  private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
  private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
  private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
  private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
  private final static Card SK = new Card(Rank.KING, Suit.SPADES);
  private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

  // TEST CARD HGH HANDS

  private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
  private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
  private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
  private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
  private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
  private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

  @Test
  public void testNothing0() {
    assertTrue(nothing73.compareTo(nothing72) > 0);
  }

  @Test
  public void testNothing1() {
    assertTrue(nothingJ.compareTo(nothing73) > 0);
  }

  @Test
  public void testNothing2() {
    assertTrue(nothingK8.compareTo(nothingJ) > 0);
  }

  @Test
  public void testNothing3() {
    assertTrue(nothingK9.compareTo(nothingK8) > 0);
  }

  @Test
  public void testNothing4() {
    assertTrue(nothingA.compareTo(nothingK8) > 0);
  }

  // Many more tests needed



  // straight flush A
  PokerHand strflA = new PokerHand(C9, C6, C10, C7, C8);
  
  strflA.order();
  strflA.getHand();

  // straight flush B
  PokerHand strflB = new PokerHand(H9, HJ, H10 , H7, H8);
  
  strflB.order();
  strflB.getHand();

  System.out.println("test strfl:(-1) "+strflA.compareTo(strflB));


  // straight  A
  PokerHand strA = new PokerHand(C2, S5, C4, HA, C3);
  
  strA.order();
  strA.getHand();

  // straight  B
  PokerHand strB = new PokerHand(D9, HJ, H10, C7 , H8);
  
  strB.order();
  strB.getHand();

  System.out.println("test str:(-1) "+strA.compareTo(strB));



  // high card A
  PokerHand hcrdA = new PokerHand(H9, C6, D4, D8, C7);
  
  hcrdA.order();
  hcrdA.getHand();

  // high card B
  PokerHand hcrdB = new PokerHand(H9, C4, D10, D8, CA);
 
  hcrdB.order();
  hcrdB.getHand();

  System.out.println("test hcrd:(-1) "+hcrdA.compareTo(hcrdB));



  // flush A
  PokerHand flushA = new PokerHand(C9, C2, C10, C7, CJ);
  
  flushA.order();
  flushA.getHand();

  // flush B
  PokerHand flushB = new PokerHand(C5, C2, C10, CA, CJ);
  
  flushB.order();
  flushB.getHand();

  System.out.println("test flush:(-1) "+flushA.compareTo(flushB));



  // full house A
  PokerHand fulhsA = new PokerHand(C9, D9, S4, C4, H9);
  
  fulhsA.order();
  fulhsA.getHand();

  // full house B
  PokerHand fulhsB = new PokerHand(C2, D2, SA, CA, HA);
  
  fulhsB.order();
  fulhsB.getHand();

  System.out.println("test fulhs:(-1) "+fulhsA.compareTo(fulhsB));


  // 1 pair A
  PokerHand pairA = new PokerHand(S9, C6, C9, D4, C8);
  
  pairA.order();
  pairA.getHand();

  // 1 pair B
  PokerHand pairB = new PokerHand(S9, C6, CJ, D4, CJ);
  
  pairB.order();
  pairB.getHand();

  System.out.println("test pair:(-1) "+pairA.compareTo(pairB));



  // 2 pair A
  PokerHand twpairA = new PokerHand(S9, C6, C9, D4, H6);
  
  twpairA.order();
  twpairA.getHand();

  // 2 pair B
  PokerHand twpairB = new PokerHand(S9, HJ, CA, D9, CJ);
  
  twpairB.order();
  twpairB.getHand();

  System.out.println("test twpair:(-1) "+twpairA.compareTo(twpairB));



  // 3 kind A
  PokerHand thrkndA = new PokerHand(C10, D6, H10, S10, C8);
  
  thrkndA.order();
  thrkndA.getHand();

  // 3 kind B
  PokerHand thrkndB = new PokerHand(CJ, D4, HJ, S10, DJ);
  
  thrkndB.order();
  thrkndB.getHand();

  System.out.println("test thrknd:(-1) "+thrkndA.compareTo(thrkndB));


  // 4 kind A
  PokerHand fourkndA = new PokerHand(C4, SJ, H4, S4, D4);
  
  fourkndA.order();
  fourkndA.getHand();

  // 4 kind B
  PokerHand fourkndB = new PokerHand(CJ, SJ, HJ, S10, DJ);
  
  fourkndB.order();
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
