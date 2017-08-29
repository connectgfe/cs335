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


  deck.add(C2); deck.add(C3); deck.add(C4); deck.add(C5); deck.add(C6);
  deck.add(C7); deck.add(C8); deck.add(C9); deck.add(C10); deck.add(CJ); deck.add(CQ); deck.add(CK); deck.add(CA);

  deck.add(D2); deck.add(D3); deck.add(D4); deck.add(D5); deck.add(D6);
  deck.add(D7); deck.add(D8); deck.add(D9); deck.add(D10); deck.add(DJ); deck.add(DQ); deck.add(DK); deck.add(DA);



/*
   for (Suit suit : Suit.values()) {
          for (Rank rank : Rank.values()) {
             deck.add(new Card(rank, suit));
         } 
     } 

*/

// set up players
    game= new LinkedList<Player>();
    commCards= new LinkedList<Card>();

    for(int i=0;i<plyrs;i++){
      Player plr= new Player(); 
      game.add(i,plr);
      deal2(game.get(i).pkhand);
     }
 
    showhands();

  
    deal5(commCards); 
 
     for(int i=0;i<plyrs;i++){
      Player plr= new Player(); 
      game.get(i).pkhand.addAll(commCards);
//      game.get(i).pkhand.order();
     }

    showhands();

  }

  public void showhands(){

    for(int i=0;i<game.size();i++){
     System.out.print("Player "+(i+1)+": ");
     game.get(i).getCards();

    }


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



