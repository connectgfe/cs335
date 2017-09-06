//package model;

import java.util.*;
import model.PokerHand;
import model.Suit;
import model.Card;
import model.Rank;
import model.Azholdem2;
import model.Player;

public class Game{

   public static void main(String[] args){

  
   System.out.print("\nWELCOME TO ARIZONA HOLDEM!!\n\nHow many players? ");

   String gameOn;
   Scanner sc = new Scanner(System.in);
   int i = sc.nextInt();
   
   Azholdem2 game1 = new Azholdem2(i);
   // main game loop
     while(i!=0){

       game1.runGame(); 
        
       System.out.print("Play another game? ");         

       gameOn = sc.next();

       if(gameOn.equals("n")){
        i=0;
       } 
     
       System.out.println("------------------");

    }

   System.out.println("GoodBye!!");   

   }

}
