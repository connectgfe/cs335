

import java.util.LinkedList;

public class Deck {

  LinkedList<Card> deck;

  public Deck() {
  
   deck=new LinkedList<Card>();   

   int j=0;    
   for(int i=0;i<44;i++){
 
    if(i%11==0 || i%11==1){continue;} 
//    System.out.println(Integer.toString(i%11));

    
    if(i<11){ 
     Card next=new Card(Integer.toString(i%11),"H"); 
     deck.add(j,next); 
     j++; 
    } 
   
    if(i>10 && i<22){ 
     Card next=new Card(Integer.toString(i%11),"S"); 
     deck.add(j,next); 
     j++; 
     }
   
    if(i>21 && i<33){ 
     Card next=new Card( Integer.toString(i%11),"C"); 
     deck.add(j,next); 
     j++; 
    } 
   
   if(i>32 && i<44){ 
     Card next=new Card( Integer.toString(i%11),"D"); 
     deck.add(j,next); 
     j++;  
   }


  }

   String s=null;
   String r=null;

 
  for(int i=j;i<52;i++){

   if(j>35 && j<40){ s="H";} 
   if(j>39 && j<44){ s="S";}
   if(j>43 && j<48){ s="C";} 
   if(j>47 && j<52){ s="D";}  

   if(i%4==0){r="A";} 
   if(i%4==1){r="J";} 
   if(i%4==2){r="Q";} 
   if(i%4==3){r="K";} 

   Card next=new Card(r,s); 
     deck.add(j,next); 
     j++; 

   }


 
  for(int i=0;i<j;i++){
//    System.out.println(deck.get(i).rank+""+deck.get(i).suit);   
  }



 }

 
  public void deal(Player plyr){

    int cnt=0;
    while(cnt<5){
   
       int crd=(int)(Math.random()* 52);
     //  System.out.println(deck.get(cnt).rank);

       plyr.hand.add(cnt,deck.get(crd)); 
       cnt++;
    }
    
  } 


}

class Card {

  String rank;
  String suit;

  public Card(String inrank, String insuit){

  rank=inrank;
  suit=insuit;

  }

}

class Player {

 String player;
 LinkedList<Card> hand;

 public Player(String plyr){

 hand=new LinkedList<Card>(); 
 player=plyr; 
// System.out.println(player+" is playing");
 
 }

 public void gethand(){

    for(int i=0;i<5;i++){
       System.out.print(hand.get(i).rank+""+hand.get(i).suit+" ");
    } 
    
    System.out.println(); 


 }

}

class Cardgame {

  Player pl1,pl2;

  public Cardgame(Player p1, Player p2){
     pl1=p1;
     pl2=p2;
  }

  public void showhands(){

  System.out.println(pl1.player);
  for(int i=0;i<5;i++){
       System.out.print(pl1.hand.get(i).rank+""+pl1.hand.get(i).suit+" ");
    } 
    
    System.out.println(); 

  System.out.println(pl2.player);
  for(int i=0;i<5;i++){
       System.out.print(pl2.hand.get(i).rank+""+pl2.hand.get(i).suit+" ");
    } 
    
    System.out.println(); 

  }

 


}
