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

 
 public void getbest(){

  PokerHand p1=new PokerHand(pkhand.get(0),pkhand.get(1),
  pkhand.get(2),pkhand.get(3),pkhand.get(4));
/*
  PokerHand p1=new PokerHand();
  p1.hand.add(0,pkhand.hand.get(0));
  p1.hand.add(1,pkhand.hand.get(1));
  p1.hand.add(2,pkhand.hand.get(2));
  p1.hand.add(3,pkhand.hand.get(3));
  p1.hand.add(4,pkhand.hand.get(4));
*/


  PokerHand p2=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p2=new PokerHand();
  p2.hand.add(0,pkhand.hand.get(1));
  p2.hand.add(1,pkhand.hand.get(2));
  p2.hand.add(2,pkhand.hand.get(3));
  p2.hand.add(3,pkhand.hand.get(4));
  p2.hand.add(4,pkhand.hand.get(5));
*/


  PokerHand p3=new PokerHand(pkhand.get(6),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p3=new PokerHand();
  p3.hand.add(0,pkhand.hand.get(2));
  p3.hand.add(1,pkhand.hand.get(3));
  p3.hand.add(2,pkhand.hand.get(4));
  p3.hand.add(3,pkhand.hand.get(5));
  p3.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p4=new PokerHand(pkhand.get(0),pkhand.get(6),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p4=new PokerHand();
  p4.hand.add(0,pkhand.hand.get(0));
  p4.hand.add(1,pkhand.hand.get(3));
  p4.hand.add(2,pkhand.hand.get(4));
  p4.hand.add(3,pkhand.hand.get(5));
  p4.hand.add(4,pkhand.hand.get(6));
*/



  PokerHand p5=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p5=new PokerHand();
  p5.hand.add(0,pkhand.hand.get(0));
  p5.hand.add(1,pkhand.hand.get(1));
  p5.hand.add(2,pkhand.hand.get(4));
  p5.hand.add(3,pkhand.hand.get(5));
  p5.hand.add(4,pkhand.hand.get(6));
*/



  PokerHand p6=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(0),pkhand.get(6),pkhand.get(5));
/*
  PokerHand p6=new PokerHand();
  p6.hand.add(0,pkhand.hand.get(0));
  p6.hand.add(1,pkhand.hand.get(1));
  p6.hand.add(2,pkhand.hand.get(2));
  p6.hand.add(3,pkhand.hand.get(5));
  p6.hand.add(4,pkhand.hand.get(6));
*/



  PokerHand p7=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(6));
/*
  PokerHand p7=new PokerHand();
  p7.hand.add(0,pkhand.hand.get(1));
  p7.hand.add(1,pkhand.hand.get(2));
  p7.hand.add(2,pkhand.hand.get(3));
  p7.hand.add(3,pkhand.hand.get(4));
  p7.hand.add(4,pkhand.hand.get(6));
*/



  PokerHand p8=new PokerHand(pkhand.get(0),pkhand.get(2),
  pkhand.get(3),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p8=new PokerHand();
  p8.hand.add(0,pkhand.hand.get(0));
  p8.hand.add(1,pkhand.hand.get(2));
  p8.hand.add(2,pkhand.hand.get(3));
  p8.hand.add(3,pkhand.hand.get(4));
  p8.hand.add(4,pkhand.hand.get(5));
*/


  PokerHand p9=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));
/*
  PokerHand p9=new PokerHand();
  p9.hand.add(0,pkhand.hand.get(1));
  p9.hand.add(1,pkhand.hand.get(3));
  p9.hand.add(2,pkhand.hand.get(4));
  p9.hand.add(3,pkhand.hand.get(5));
  p9.hand.add(4,pkhand.hand.get(6));
*/

  PokerHand p10=new PokerHand(pkhand.get(0),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(5));
/* 
  PokerHand p10=new PokerHand();
  p10.hand.add(0,pkhand.hand.get(0));
  p10.hand.add(1,pkhand.hand.get(2));
  p10.hand.add(2,pkhand.hand.get(4));
  p10.hand.add(3,pkhand.hand.get(5));
  p10.hand.add(4,pkhand.hand.get(6));
*/

  PokerHand p11=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(0),pkhand.get(5));
/* 
  PokerHand p11=new PokerHand();
  p11.hand.add(0,pkhand.hand.get(0));
  p11.hand.add(1,pkhand.hand.get(1));
  p11.hand.add(2,pkhand.hand.get(3));
  p11.hand.add(3,pkhand.hand.get(5));
  p11.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p12=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(0));
/* 
  PokerHand p12=new PokerHand();
  p12.hand.add(0,pkhand.hand.get(0));
  p12.hand.add(1,pkhand.hand.get(1));
  p12.hand.add(2,pkhand.hand.get(2));
  p12.hand.add(3,pkhand.hand.get(4));
  p12.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p13=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(2),pkhand.get(3),pkhand.get(5));
/*
  PokerHand p13=new PokerHand();
  p13.hand.add(0,pkhand.hand.get(0));
  p13.hand.add(1,pkhand.hand.get(1));
  p13.hand.add(2,pkhand.hand.get(2));
  p13.hand.add(3,pkhand.hand.get(3));
  p13.hand.add(4,pkhand.hand.get(5));
*/


  PokerHand p14=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(3));
/* 
  PokerHand p14=new PokerHand();
  p14.hand.add(0,pkhand.hand.get(1));
  p14.hand.add(1,pkhand.hand.get(2));
  p14.hand.add(2,pkhand.hand.get(3));
  p14.hand.add(3,pkhand.hand.get(4));
  p14.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p15=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(0),pkhand.get(4),pkhand.get(5)); 
/*
  PokerHand p15=new PokerHand();
  p15.hand.add(0,pkhand.hand.get(0));
  p15.hand.add(1,pkhand.hand.get(1));
  p15.hand.add(2,pkhand.hand.get(3));
  p15.hand.add(3,pkhand.hand.get(4));
  p15.hand.add(4,pkhand.hand.get(5));
*/


  PokerHand p16=new PokerHand(pkhand.get(1),pkhand.get(2),
  pkhand.get(6),pkhand.get(4),pkhand.get(5)); 
/*
  PokerHand p16=new PokerHand();
  p16.hand.add(0,pkhand.hand.get(1));
  p16.hand.add(1,pkhand.hand.get(2));
  p16.hand.add(2,pkhand.hand.get(4));
  p16.hand.add(3,pkhand.hand.get(5));
  p16.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p17=new PokerHand(pkhand.get(0),pkhand.get(3),
  pkhand.get(6),pkhand.get(2),pkhand.get(5));
/* 
  PokerHand p17=new PokerHand();
  p17.hand.add(0,pkhand.hand.get(0));
  p17.hand.add(1,pkhand.hand.get(2));
  p17.hand.add(2,pkhand.hand.get(3));
  p17.hand.add(3,pkhand.hand.get(5));
  p17.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p18=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(0));
/* 
  PokerHand p18=new PokerHand();
  p18.hand.add(0,pkhand.hand.get(0));
  p18.hand.add(1,pkhand.hand.get(1));
  p18.hand.add(2,pkhand.hand.get(3));
  p18.hand.add(3,pkhand.hand.get(4));
  p18.hand.add(4,pkhand.hand.get(6));
*/


  PokerHand p19=new PokerHand(pkhand.get(1),pkhand.get(0),
  pkhand.get(2),pkhand.get(4),pkhand.get(5));
/* 
  PokerHand p19=new PokerHand();
  p19.hand.add(0,pkhand.hand.get(0));
  p19.hand.add(1,pkhand.hand.get(1));
  p19.hand.add(2,pkhand.hand.get(2));
  p19.hand.add(3,pkhand.hand.get(4));
  p19.hand.add(4,pkhand.hand.get(5));
*/


  PokerHand p20=new PokerHand(pkhand.get(1),pkhand.get(3),
  pkhand.get(6),pkhand.get(2),pkhand.get(5));
/* 
  PokerHand p20=new PokerHand();
  p20.hand.add(0,pkhand.hand.get(1));
  p20.hand.add(1,pkhand.hand.get(2));
  p20.hand.add(2,pkhand.hand.get(3));
  p20.hand.add(3,pkhand.hand.get(5));
  p20.hand.add(4,pkhand.hand.get(6));
*/



  PokerHand p21=new PokerHand(pkhand.get(0),pkhand.get(3),
  pkhand.get(6),pkhand.get(4),pkhand.get(2));
/* 
  PokerHand p21=new PokerHand();
  p21.hand.add(0,pkhand.hand.get(0));
  p21.hand.add(1,pkhand.hand.get(2));
  p21.hand.add(2,pkhand.hand.get(3));
  p21.hand.add(3,pkhand.hand.get(4));
  p21.hand.add(4,pkhand.hand.get(6));
*/

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



  Collections.sort(best);



/*
best.get(0).gethand();
best.get(1).gethand();
best.get(2).gethand();
best.get(3).gethand();
best.get(4).gethand();
best.get(5).gethand();
best.get(6).gethand();
*/

/*
  System.out.print("Best hand: ");
  best.get(20).gethand();
  System.out.println();
*/


 }


}


