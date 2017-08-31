/*
Project: Arizona HoldEm Iteration 1: PokerHand
Author: Giulio Esposito 23264886
Date Due: 8/30/17 11:55 pm at GitHub

*/
package model;
import java.util.*;

public class Azholdem {

  LinkedList<Player> game;
  LinkedList<Card> commCards;
  LinkedList<Card> deck;  
  LinkedList<PokerHand> winner;

  public Azholdem(int plyrs){



// set up deck    
    deck= new LinkedList<Card>();
 Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
 Card C3 = new Card(Rank.THREE, Suit.CLUBS);
 Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
 Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
 Card C6 = new Card(Rank.SIX, Suit.CLUBS);
 Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
 Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
 Card C9 = new Card(Rank.NINE, Suit.CLUBS);
 Card C10 = new Card(Rank.TEN, Suit.CLUBS);
 Card CJ = new Card(Rank.JACK, Suit.CLUBS);
 Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
 Card CK = new Card(Rank.KING, Suit.CLUBS);
 Card CA = new Card(Rank.ACE, Suit.CLUBS);

 Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
 Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
 Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
 Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
 Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
 Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
 Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
 Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
 Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
 Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
 Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
 Card DK = new Card(Rank.KING, Suit.DIAMONDS);
 Card DA = new Card(Rank.ACE, Suit.DIAMONDS);


 Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
 Card H3 = new Card(Rank.THREE, Suit.HEARTS);
 Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
 Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
 Card H6 = new Card(Rank.SIX, Suit.HEARTS);
 Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
 Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
 Card H9 = new Card(Rank.NINE, Suit.HEARTS);
 Card H10 = new Card(Rank.TEN, Suit.HEARTS);
 Card HJ = new Card(Rank.JACK, Suit.HEARTS);
 Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
 Card HK = new Card(Rank.KING, Suit.HEARTS);
 Card HA = new Card(Rank.ACE, Suit.HEARTS);

 Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
 Card S3 = new Card(Rank.THREE, Suit.SPADES);
 Card S4 = new Card(Rank.FOUR, Suit.SPADES);
 Card S5 = new Card(Rank.FIVE, Suit.SPADES);
 Card S6 = new Card(Rank.SIX, Suit.SPADES);
 Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
 Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
 Card S9 = new Card(Rank.NINE, Suit.SPADES);
 Card S10 = new Card(Rank.TEN, Suit.SPADES);
 Card SJ = new Card(Rank.JACK, Suit.SPADES);
 Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
 Card SK = new Card(Rank.KING, Suit.SPADES);
 Card SA = new Card(Rank.ACE, Suit.SPADES);

 
  deck.add(C2); deck.add(C3); deck.add(C4); deck.add(C5); deck.add(C6);
  deck.add(C7); deck.add(C8); deck.add(C9); deck.add(C10); deck.add(CJ); deck.add(CQ); deck.add(CK); deck.add(CA);

  deck.add(D2); deck.add(D3); deck.add(D4); deck.add(D5); deck.add(D6);
  deck.add(D7); deck.add(D8); deck.add(D9); deck.add(D10); deck.add(DJ); deck.add(DQ); deck.add(DK); deck.add(DA);

  deck.add(S2); deck.add(S3); deck.add(S4); deck.add(S5); deck.add(S6);
  deck.add(S7); deck.add(S8); deck.add(S9); deck.add(S10); deck.add(SJ); deck.add(SQ); deck.add(SK); deck.add(SA);

  deck.add(H2); deck.add(H3); deck.add(H4); deck.add(H5); deck.add(H6);
  deck.add(H7); deck.add(H8); deck.add(H9); deck.add(H10); deck.add(HJ); deck.add(HQ); deck.add(HK); deck.add(HA);




    // set game, deal Players 2 cards
    game= new LinkedList<Player>();
    winner = new LinkedList<PokerHand>();

    for(int i=0;i<plyrs;i++){
      Player plr= new Player(); 
      game.add(i,plr);
      deal2(game.get(i).pkhand);
     }
 


    // deal comm cards  
    commCards= new LinkedList<Card>();
    deal5(commCards); 

getCommCards();

//getPlayerInfo();

    // add comm cards to Players hands 
    for(int i=0;i<plyrs;i++){
      game.get(i).pkhand.addAll(commCards);
//    game.get(i).pkhand.order();
    }

getPlayerInfo();

    // try to get best had for player1
//System.out.println("here");
//    game.get(0).getBest();


  }


  


  public void getPlayerInfo(){
  


    for(int i=0;i<game.size();i++){
     System.out.print("Player "+(i+1));
     System.out.print(": $"+game.get(i).ante+" - ");
     game.get(i).getCards();
   
     // add in comm cards 
     game.get(i).pkhand.addAll(commCards);
     winner.add(game.get(i).getBest()); 
     winner.get(i).getHand();
    }


  }

  public void getCommCards(){


    System.out.print("Community Cards: ");
    for(int i=0;i<commCards.size();i++){
     System.out.print(commCards.get(i).toString()+" ");

    }
    System.out.println();

  }


  public Player getPlyr(int val){

   Player retval = game.get(val);
   return retval;
  }

  public void deal5(LinkedList<Card> comm){

     if(deck.size()<6){
       System.out.println("Deck done");
     }
     int crdcnt=0;
     int cnt=deck.size(); 
    
     while(crdcnt<5){
   
       int crd=(int)(Math.random()* cnt);
//  System.out.println(deck.get(cnt).rank);
       comm.add(crdcnt,deck.get(crd)); 
       
       deck.remove(crd);
       crdcnt++;
       cnt--; 
        
      }
    
  } 

 
  public void deal2(LinkedList<Card> hand){

     if(deck.size()<3){
       System.out.println("Deck done");
     }
     int cnt=deck.size();
     int crdcnt=0; 
    
     while(crdcnt<2){
/*   
       int crd=(int)(Math.random()* 52);
     //  System.out.println(deck.get(cnt).rank);

       pkhand.hand.add(cnt,deck.get(crd)); 
       cnt++;
*/
 
       int crd=(int)(Math.random()* cnt);
//  System.out.println(deck.get(cnt).rank);
       hand.add(crdcnt,deck.get(crd)); 
       
       deck.remove(crd);
       crdcnt++;
       cnt--; 
     }      
  }


}



