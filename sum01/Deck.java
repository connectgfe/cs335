
import java.util.LinkedList;
import java.util.List;

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

       plyr.pkhand.hand.add(cnt,deck.get(crd)); 
       cnt++;
    }
    
  } 

 
  public void deal2(LinkedList<Card> pkhand){

    int cnt=0;
    while(cnt<5){
   
       int crd=(int)(Math.random()* 52);
     //  System.out.println(deck.get(cnt).rank);

       pkhand.add(cnt,deck.get(crd)); 
       cnt++;
    }
    
  } 



}

class Card implements Comparable<Card>{

  String rank;
  String suit;

  public Card(String inrank, String insuit){

  rank=inrank;
  suit=insuit;

  }

 public int compareRank(String fst, String scd){


     int a=0;
     int b=0;

     if( fst.equals("2") ){ a = 1;} 
     if( fst.equals("3") ){ a = 2;} 
     if( fst.equals("4") ){ a = 3;}
     if( fst.equals("5") ){ a = 4;} 
     if( fst.equals("6") ){ a = 5;} 
     if( fst.equals("7") ){ a = 6;}
     if( fst.equals("8") ){ a = 7;} 
     if( fst.equals("9") ){ a = 8;} 
     if( fst.equals("10") ){ a = 9;}
     if( fst == "J" ){ a = 10;} 
     if( fst == "Q" ){ a = 11;} 
     if( fst == "K" ){ a = 12;}
     if( fst == "A" ){ a = 13;} 
 
     if( scd.equals("2") ){ b = 1;} 
     if( scd.equals("3") ){ b = 2;} 
     if( scd.equals("4") ){ b = 3;}
     if( scd.equals("5") ){ b = 4;} 
     if( scd.equals("6") ){ b = 5;} 
     if( scd.equals("7") ){ b = 6;}
     if( scd.equals("8") ){ b = 7;} 
     if( scd.equals("9") ){ b = 8;} 
     if( scd.equals("10") ){ b = 9;}
     if( scd == "J" ){ b = 10;} 
     if( scd == "Q" ){ b = 11;} 
     if( scd == "K" ){ b = 12;}
     if( scd == "A" ){ b = 13;} 

     System.out.println(a+" "+b);

     if(a==b){ return 0;}
     if(a>b){return 1;}
     return -1;

 }

  public int compareTo(Card jam){

//  System.out.println(jam.hand.get(0).rank+" "+hand.get(0).rank);
  
  int retval=compareRank(rank,jam.rank);
//  System.out.println(retval);

  if(retval==1){
    System.out.println("this>that");
    return 1;}

  if(retval==0){
    System.out.println("that=this");
    return 0;}

  if(retval==-1){
    System.out.println("that>this");
    return -1;}
 
  

  return -2;

  }



}

class Player {

 String player;
// LinkedList<Card> hand;

 Pokerhand pkhand;


 public Player(String plyr){


  pkhand = new Pokerhand();
//  hand=new LinkedList<Card>(); 

  player=plyr; 
// System.out.println(player+" is playing");


 
 }

 public void shwhand(){

 pkhand.gethand();

 }


/*
 public void gethand(){

    for(int i=0;i<5;i++){
       System.out.print(hand.get(i).rank+""+hand.get(i).suit+" ");
    } 
    
    System.out.println(); 
 }

 public void order(){


  int cnt=-1;
   while(cnt!=0){ 

      cnt=0; 
       for(int j=0;j<4;j++){

        if(compareRank(hand.get(j).rank,hand.get(j+1).rank)==1){

        hand.add(j,hand.remove(j+1));
        cnt++; 
        }
       }
    
  }
 

}

 public int compareRank(String fst, String scd){


     int a=0;
     int b=0;

     if( fst.equals("2") ){ a = 1;} 
     if( fst.equals("3") ){ a = 2;} 
     if( fst.equals("4") ){ a = 3;}
     if( fst.equals("5") ){ a = 4;} 
     if( fst.equals("6") ){ a = 5;} 
     if( fst.equals("7") ){ a = 6;}
     if( fst.equals("8") ){ a = 7;} 
     if( fst.equals("9") ){ a = 8;} 
     if( fst.equals("10") ){ a = 9;}
     if( fst == "J" ){ a = 10;} 
     if( fst == "Q" ){ a = 11;} 
     if( fst == "K" ){ a = 12;}
     if( fst == "A" ){ a = 13;} 
 
     if( scd.equals("2") ){ b = 1;} 
     if( scd.equals("3") ){ b = 2;} 
     if( scd.equals("4") ){ b = 3;}
     if( scd.equals("5") ){ b = 4;} 
     if( scd.equals("6") ){ b = 5;} 
     if( scd.equals("7") ){ b = 6;}
     if( scd.equals("8") ){ b = 7;} 
     if( scd.equals("9") ){ b = 8;} 
     if( scd.equals("10") ){ b = 9;}
     if( scd == "J" ){ b = 10;} 
     if( scd == "Q" ){ b = 11;} 
     if( scd == "K" ){ b = 12;}
     if( scd == "A" ){ b = 13;} 



     if(a==b){ return -1;}
     if(a>b){return 1;}
     return 0;

 }

*/


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
       System.out.print(pl1.pkhand.hand.get(i).rank+""+pl1.pkhand.hand.get(i).suit+" ");
    } 
    
    System.out.println(); 

  System.out.println(pl2.player);
  for(int i=0;i<5;i++){
       System.out.print(pl2.pkhand.hand.get(i).rank+""+pl2.pkhand.hand.get(i).suit+" ");
    } 
    
    System.out.println(); 

  }



}


class Pokerhand implements Comparable<Pokerhand> {

   LinkedList<Card> hand;

   public Pokerhand(){

   hand = new LinkedList<Card>(); 

   Deck deck= new Deck();

   deck.deal2(hand);

   order();


   }

 public void gethand(){

    for(int i=0;i<5;i++){
       System.out.print(hand.get(i).rank+""+hand.get(i).suit+" ");
    } 
    
    System.out.println(); 
 }

 public void order(){


  int cnt=-1;
   while(cnt!=0){ 

      cnt=0; 
       for(int j=0;j<4;j++){

        if(compareRank(hand.get(j).rank,hand.get(j+1).rank)==1){

        hand.add(j,hand.remove(j+1));
        cnt++; 
        }
       }
    
  }
 

}

 public int compareRank(String fst, String scd){


     int a=0;
     int b=0;

     if( fst.equals("2") ){ a = 1;} 
     if( fst.equals("3") ){ a = 2;} 
     if( fst.equals("4") ){ a = 3;}
     if( fst.equals("5") ){ a = 4;} 
     if( fst.equals("6") ){ a = 5;} 
     if( fst.equals("7") ){ a = 6;}
     if( fst.equals("8") ){ a = 7;} 
     if( fst.equals("9") ){ a = 8;} 
     if( fst.equals("10") ){ a = 9;}
     if( fst == "J" ){ a = 10;} 
     if( fst == "Q" ){ a = 11;} 
     if( fst == "K" ){ a = 12;}
     if( fst == "A" ){ a = 13;} 
 
     if( scd.equals("2") ){ b = 1;} 
     if( scd.equals("3") ){ b = 2;} 
     if( scd.equals("4") ){ b = 3;}
     if( scd.equals("5") ){ b = 4;} 
     if( scd.equals("6") ){ b = 5;} 
     if( scd.equals("7") ){ b = 6;}
     if( scd.equals("8") ){ b = 7;} 
     if( scd.equals("9") ){ b = 8;} 
     if( scd.equals("10") ){ b = 9;}
     if( scd == "J" ){ b = 10;} 
     if( scd == "Q" ){ b = 11;} 
     if( scd == "K" ){ b = 12;}
     if( scd == "A" ){ b = 13;} 

 //    System.out.println(a+" "+b);

     if(a==b){ return 0;}
     if(a>b){return 1;}
     return -1;

 }

  public int compareTo(Pokerhand jam){

  // return 1 this > jam ; 0 this = jam ; -1 this < jam

  // 9=ryfl 8=stfl 7=4knd 6=flhs 5=fl 4=st 3=3knd 2=22knd 1=2knd 0=hc

    int val1=0;
    int val2=0;
  // kinds
    String frtemp=fourkind();
    if(frtemp!=null){ val1=7;} 
    
    String frtempjam=jam.fourkind();
    if(frtempjam!=null){ val2=7;} 


    // 4knd tie
    if(val1==7 && val2==7){
      if(compareRank(frtemp,frtempjam)==1){
         return 1;}
      if(compareRank(frtemp,frtempjam)==-1){
         return -1;}
      if(compareRank(frtemp,frtempjam)==0){
         return 0;}
    }
 
    String trtemp=threekind();
    String frtwtemp=null;

    if(trtemp!=null){

       frtwtemp=ntwokind(trtemp);
       
         if(frtwtemp!=null){ 
            val1=6;
         }else{val1=3;}
    } 

    String trtempjam=jam.threekind();
    String frtwtempjam=null;
    if(trtempjam!=null){

       frtwtempjam=jam.ntwokind(trtempjam);
       
         if(frtwtempjam!=null){ 
            val2=6;
         }else{val2=3;}
    } 

    // flhs tie
    if(val1==6 && val2==6){
      if(compareRank(trtemp,trtempjam)==1){
         return 1;}
      if(compareRank(trtemp,trtempjam)==-1){
         return -1;}
      if(compareRank(trtemp,trtempjam)==0){
         
         if(compareRank(frtwtemp,frtwtempjam)==1){
            return 1;}

         if(compareRank(frtwtemp,frtwtempjam)==-1){
            return -1;}

         if(compareRank(frtwtemp,frtwtempjam)==0){
            return 0;}

       } 
    }   

    // 3 kind tie 
    if(val1==3 && val2==3){
      if(compareRank(trtemp,trtempjam)==1){
         return 1;}
      if(compareRank(trtemp,trtempjam)==-1){
         return -1;}
      if(compareRank(trtemp,trtempjam)==0){
         return 0;}
    } 


    String twtemp=twokind();
    if(twtemp!=null){

      String twtemp2=ntwokind(twtemp);
       
         if(twtemp2!=null){ 
            val1=2;
         }else{val1=1;}
    } 

    String twtempjam=jam.twokind();
    if(twtempjam!=null){

      String twtemp2jam=jam.ntwokind(twtempjam);
       
         if(twtemp2jam!=null){ 
            val2=2;
         }else{val2=1;}
    } 


// compare 22kind for higher pair


    // 2knd tie
    if(val1==1 && val2==1){
      if(compareRank(twtemp,twtempjam)==1){
         return 1;}
      if(compareRank(twtemp,twtempjam)==-1){
         return -1;}
      if(compareRank(twtemp,twtempjam)==0){
         return 0;}
    } 



System.out.println(val1+" "+val2);

/*   
    if(val1>val2){ return 1;}
    if(val2>val1){ return -1;}
 



  // highcard
 
    if(highcrd(jam)==1){
       System.out.println("F winner"); 
       return 1;  
    }
 
    if(highcrd(jam)==-1){
       System.out.println("L  winner"); 
       return -1;  
    }

*/

/*
  if(retval==1){
    System.out.println("this>that");
    return 1;}

  if(retval==0){
    System.out.println("that=this");
    return 0;}

  if(retval==-1){
    System.out.println("that>this");
    return -1;}
 
*/  

  return 0;



  }



   public int highcrd(Pokerhand jam){

     for(int i=4;i>-1;i--){ 
    
       int retval=compareRank(hand.get(i).rank,jam.hand.get(i).rank);
 
       if(retval==1){
          return 1;
       }

       if(retval==-1){
          return -1;
       }


     }

     return 0;


   }

  
  public String fourkind(){

    int cnt=0;
    String retval=null;

    for(int i=0;i<4;i++){

      if(hand.get(i).rank.compareTo(hand.get(i+1).rank)==0){
        retval=hand.get(i).rank; 
        cnt++;
      }
      
    }
   
    if(cnt==3){ return retval;}
    
    return retval;
  }

  public String threekind(){

    int cnt=0;
    String retval=null;

    for(int i=0;i<4;i++){

      if(hand.get(i).rank.compareTo(hand.get(i+1).rank)==0){
        retval=hand.get(i).rank; 
        cnt++;
      }
      
    }
   
    if(cnt==2){ return retval;}
    
    return retval;
  }

  public String twokind(){

    int cnt=0;
    String retval=null;

    for(int i=0;i<4;i++){

      if(hand.get(i).rank.compareTo(hand.get(i+1).rank)==0){
        retval=hand.get(i).rank; 
        cnt++;
      }
      
    }
   
    if(cnt==1){ return retval;}
    
    return retval;
  }


  public String ntwokind(String jump){

    int cnt=0;
    String retval=null;

    for(int i=0;i<4;i++){
      
     if(hand.get(i).rank.compareTo(jump)==0){
      continue; 
      }


      if(hand.get(i).rank.compareTo(hand.get(i+1).rank)==0){
        retval=hand.get(i).rank; 
        cnt++;
      }
      
    }
   
    if(cnt==1){ return retval;}
    
    return retval;
  }

}
