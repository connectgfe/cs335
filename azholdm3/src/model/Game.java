

import java.util.*;
import model.PokerHand;
import model.Suit;
import model.Card;
import model.Rank;
import model.Azholdem;
import model.Player;

public class Game{

   public static void main(String[] args){

  
   System.out.print("How many players? ");

   String gameOn;
   Scanner sc = new Scanner(System.in);
   int i = sc.nextInt();
   
   // main game loop
     while(i!=0){

       Azholdem game1 = new Azholdem(i);
       
       System.out.print("Play another game? ");         

       gameOn = sc.next();

       if(gameOn.equals("n")){
        i=0;
       } 
     


    }

   

   }

}
