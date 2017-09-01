/*
Project: Arizona HoldEm Iteration 1: PokerHand
Author: Giulio Esposito 23264886
Date Due: 8/30/17 11:55 pm at GitHub

*/
package model;
import java.util.*;


public class Player {

 double ante;
 
 LinkedList<Card> pkhand;


 public Player(){

  ante=100.00; 
  pkhand = new LinkedList<Card>();

 
 }

 public void getCards(){
 
  for(int i=0; i<pkhand.size();i++){
   System.out.print(pkhand.get(i).toString());  
  }

  System.out.println();
 }

 
 public PokerHand getBest(){




  PokerHand p1=new PokerHand(pkhand.get(0),pkhand.get(1),
  pkhand.get(2),pkhand.get(3),pkhand.get(4));


  PokerHand p2=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));



  PokerHand p3=new PokerHand(pkhand.get(6),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));




  PokerHand p4=new PokerHand(pkhand.get(0),pkhand.get(6),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));



  PokerHand p5=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));



  PokerHand p6=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(0),pkhand.get(6),pkhand.get(5));



  PokerHand p7=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(6));



  PokerHand p8=new PokerHand(pkhand.get(0),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));

  PokerHand p9=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));

  PokerHand p10=new PokerHand(pkhand.get(0),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));

  PokerHand p11=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(0),pkhand.get(5));


  PokerHand p12=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(0));


  PokerHand p13=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(2),pkhand.get(3),pkhand.get(5));


  PokerHand p14=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(3));


  PokerHand p15=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(0),pkhand.get(4),pkhand.get(5)); 


  PokerHand p16=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(5)); 


  PokerHand p17=new PokerHand(pkhand.get(0),pkhand.get(3),
  pkhand.get(6),pkhand.get(2),pkhand.get(5));


  PokerHand p18=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(0));


  PokerHand p19=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(2),pkhand.get(4),pkhand.get(5));


  PokerHand p20=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(2),pkhand.get(5));


  PokerHand p21=new PokerHand(pkhand.get(0),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(2));



  LinkedList<PokerHand> best = new LinkedList<PokerHand>();
  best.add(p1);
  best.add(p2);
  best.add(p3);
  best.add(p4);
  best.add(p5);
  best.add(p6);
  best.add(p7);
  best.add(p8);
  best.add(p9);
  best.add(p10);
  best.add(p11);
  best.add(p12);
  best.add(p13);
  best.add(p14);
  best.add(p15);
  best.add(p16);
  best.add(p17);
  best.add(p18);
  best.add(p19);
  best.add(p20);
  best.add(p21);







/*
p1.gethand();  
p2.gethand();  
p3.gethand();  
p4.gethand();  
p5.gethand();  
p6.gethand();  
p7.gethand();  

*/

/*
  for(int i=0;i<best.size();i++){
    best.get(i).getHand();
  }
*/


  Collections.sort(best);



  System.out.print("Best hand: ");
  best.get(20).getHand();
  System.out.println();


  return best.get(20);

 }


}


