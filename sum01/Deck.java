
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

 
  public void deal5(LinkedList<Card> comm){

    int cnt=0;
    while(cnt<5){
   
       int crd=(int)(Math.random()* 52);
     //  System.out.println(deck.get(cnt).rank);

       comm.add(cnt,deck.get(crd)); 
       cnt++;
    }
    
  } 

 
  public void deal2(Pokerhand pkhand){

    int cnt=0;
    while(cnt<2){
   
       int crd=(int)(Math.random()* 52);
     //  System.out.println(deck.get(cnt).rank);

       pkhand.hand.add(cnt,deck.get(crd)); 
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
 double ante;
 Pokerhand pkhand;


 public Player(String plyr){

  player=plyr; 
  ante=100.00; 
  pkhand = new Pokerhand();

  Deck deck1= new Deck();
  deck1.deal2(pkhand);

 
 }

 public void shwhand(){

 pkhand.gethand();

 }



}

class Azholdem {

  LinkedList<Player> game;
  LinkedList<Card> comm;

  public Azholdem(int plyrs){

    game= new LinkedList<Player>();
    comm= new LinkedList<Card>();

    for(int i=0;i<plyrs;i++){
      Player plr= new Player(Integer.toString(i)); 
      game.add(i,plr);
     }
 
    showhands();
  
    Deck deal=new Deck(); 
    deal.deal5(comm); 
 
     for(int i=0;i<plyrs;i++){
      Player plr= new Player(Integer.toString(i)); 
      game.get(i).pkhand.hand.addAll(comm);
      game.get(i).pkhand.order();
     }

    showhands();

  }

  public void showhands(){

    for(int i=0;i<game.size();i++){
     System.out.print("Player "+(i+1)+": ");
     game.get(i).pkhand.gethand();

    }


  }



}


class Pokerhand implements Comparable<Pokerhand> {

   LinkedList<Card> hand;

   public Pokerhand(){

   hand = new LinkedList<Card>(); 

/*
   Deck deck= new Deck();

   deck.deal5(hand);

   order();
*/

   }

   public Pokerhand(String c1, String c2, String c3, String c4, String c5){

   hand = new LinkedList<Card>();

   Card first = mkcard(c1);
   hand.add(0,first);
 
   Card second = mkcard(c2);
   hand.add(1,second);
 
   Card third = mkcard(c3);
   hand.add(2,third);
 
   Card fourth = mkcard(c4);
   hand.add(3,fourth);

   Card fifth = mkcard(c5);
   hand.add(4,fifth);

   order();
 
   }


  public Card mkcard(String crd){

   String rnk=null;
   String sut=null;
     if(crd.length()==3){
        rnk=crd.substring(0,2); 
        sut=crd.substring(2); 
     }else{
     rnk=crd.substring(0,1);
     sut=crd.substring(1);
     }
     

     Card retval=new Card(rnk,sut);

     return retval;
  }


   public void gethand(){

    for(int i=0;i<hand.size();i++){
       System.out.print(hand.get(i).rank+""+hand.get(i).suit+" ");
    } 
    
    System.out.println(); 
   }

  public void order(){


  int cnt=-1;
   while(cnt!=0){ 

      cnt=0; 
       for(int j=0;j<(hand.size()-1);j++){

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
     if( fst.equals( "J" )){ a = 10;} 
     if( fst.equals( "Q" )){ a = 11;} 
     if( fst.equals( "K" )){ a = 12;}
     if( fst.equals( "A" )){ a = 13;} 
 
     if( scd.equals("2") ){ b = 1;} 
     if( scd.equals("3") ){ b = 2;} 
     if( scd.equals("4") ){ b = 3;}
     if( scd.equals("5") ){ b = 4;} 
     if( scd.equals("6") ){ b = 5;} 
     if( scd.equals("7") ){ b = 6;}
     if( scd.equals("8") ){ b = 7;} 
     if( scd.equals("9") ){ b = 8;} 
     if( scd.equals("10") ){ b = 9;}
     if( scd.equals( "J" )){ b = 10;} 
     if( scd.equals( "Q" )){ b = 11;} 
     if( scd.equals( "K" )){ b = 12;}
     if( scd.equals( "A" )){ b = 13;} 

 //    System.out.println(a+" "+b);

     if(a==b){ return 0;}
     if(a>b){return 1;}
     return -1;

 }

  public int compareTo(Pokerhand jam){

  // return 1 this > jam ; 0 this = jam ; -1 this < jam

  // 9=ryfl 8=stfl 7=4knd 6=flhs 5=fl 4=st 3=3knd 2=22knd 1=2knd 0=hc

    int val1=-1;
    int val2=-1;



  // highcard
 
    if(highcrd(jam)==1){
       val1=0;   
    }
 
    if(highcrd(jam)==-1){
       val2=0;  
   }



// 22kind
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


  // straight
   if(straight()==1){val1=4;}
   if(jam.straight()==1){val2=4;}


  // flush
   if(flush()==1){val1=5;}
   if(jam.flush()==1){val2=5;}
  


// compare 22kind for higher pair

    // flhs
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



  // 4knd 
    String frtemp=fourkind();
    if(frtemp!=null){ val1=7;} 
    
    String frtempjam=jam.fourkind();
    if(frtempjam!=null){ val2=7;} 



  // straight flush
   if(straight()==1 && flush()==1){val1=8;}
   if(jam.straight()==1 && jam.flush()==1){val2=8;}

  // royal flush
   if(straight()==1 && flush()==1 && hand.get(4).rank.equals("A")){val1=9;}
   if(jam.straight()==1 && jam.flush()==1 && jam.hand.get(4).rank.equals("A")){val2=9;}




System.out.println(val1+" "+val2);


    if(val1>val2){ return 1;}
    if(val1<val2){ return -1;}


  // straight tie
  


   // flush tie

   if(val1==5 || val1==7 || val1==8 || val1==4){
 
    if(highcrd(jam)==1){
       return 1;   
    }
     if(highcrd(jam)==-1){
       return -1;  
    }
   }

    // 4knd tie
    if(val1==7 && val2==7){
      if(compareRank(frtemp,frtempjam)==1){
         return 1;}
      if(compareRank(frtemp,frtempjam)==-1){
         return -1;}
      if(compareRank(frtemp,frtempjam)==0){
         return 0;}
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



    // 2knd tie
    if(val1==1 && val2==1){
      if(compareRank(twtemp,twtempjam)==1){
         return 1;}
      if(compareRank(twtemp,twtempjam)==-1){
         return -1;}
      if(compareRank(twtemp,twtempjam)==0){
         return 0;}
    } 
 


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

    String retval=null;

      if(hand.get(0).rank.compareTo(hand.get(1).rank)==0 && hand.get(1).rank.compareTo(hand.get(2).rank)==0 && hand.get(2).rank.compareTo(hand.get(3).rank)==0) {
        retval=hand.get(0).rank;             
       }
        
       if(hand.get(1).rank.compareTo(hand.get(2).rank)==0 && hand.get(2).rank.compareTo(hand.get(3).rank)==0 && hand.get(3).rank.compareTo(hand.get(4).rank)==0){
        retval=hand.get(1).rank;             
       }
      
     
     return retval;
  }

  public String threekind(){


    String retval=null;

      if(hand.get(0).rank.compareTo(hand.get(1).rank)==0 && hand.get(1).rank.compareTo(hand.get(2).rank)==0) {
        retval=hand.get(0).rank;             
       }
 
      if(hand.get(1).rank.compareTo(hand.get(2).rank)==0 && hand.get(2).rank.compareTo(hand.get(3).rank)==0 ) {
        retval=hand.get(1).rank;             
       }
 
      if(hand.get(2).rank.compareTo(hand.get(3).rank)==0 && hand.get(3).rank.compareTo(hand.get(4).rank)==0 ) {
        retval=hand.get(2).rank;             
       }
 
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

 
  public int flush(){
  
    int cnt=0;

    for(int i=0;i<4;i++){

      if(hand.get(i).suit.compareTo(hand.get(i+1).suit)==0){
        cnt++;
      }
      
    }

   if(cnt==4){return 1;} 

   return 0;
  }


  public int straight(){

// if i+1 is 1 greater

   int a=0;
   int b=0;
   for(int i=0;i<5;i++){
 
     String fst=hand.get(i).rank;
//System.out.println(fst);
     if( fst.equals("2") ){ a = 1;} 
     if( fst.equals("3") ){ a = 2;} 
     if( fst.equals("4") ){ a = 3;}
     if( fst.equals("5") ){ a = 4;} 
     if( fst.equals("6") ){ a = 5;} 
     if( fst.equals("7") ){ a = 6;}
     if( fst.equals("8") ){ a = 7;} 
     if( fst.equals("9") ){ a = 8;} 
     if( fst.equals("10") ){ a = 9;}
     if( fst.equals( "J" )){ a = 10;} 
     if( fst.equals( "Q" )){ a = 11;} 
     if( fst.equals( "K" )){ a = 12;}
     if( fst.equals( "A" )){ a = 13;} 

     if(i==0){ 
//System.out.println("no1"+a+" "+b+fst);
        b=a;}else{
      if(b==(a-1)){b=a;}else{return 0;}}

//System.out.println(a+" "+b);

   }

   return 1;
  }

 


}
