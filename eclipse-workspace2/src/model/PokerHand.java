//package model;
import java.util.*;
// Model a five card PokerHand that is constructed with five Card objects
//
// PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
//
public class PokerHand implements Comparable<PokerHand> {


  LinkedList<Card> hand = new LinkedList<Card>();

  // Construct a five card poker hand.
  public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) throws DuplicateCardException {
  
  hand.add(c1);
  hand.add(c2);
  hand.add(c3);
  hand.add(c4);
  hand.add(c5);

  order();

   }


  public void order(){

  int cnt=-1;
   while(cnt!=0){ 

      cnt=0; 
       for(int j=0;j<(hand.size()-1);j++){

         if(compareRank(hand.get(j),hand.get(j+1))==1){

         hand.add(j,hand.remove(j+1));
         cnt++; 
         }
       

       }
    
  }
 

 }

  public int compareRank(Card first, Card second){

    if(first.getRank().getValue()>second.getRank().getValue()){
      return 1;
    }
    if(first.getRank().getValue()<second.getRank().getValue()){
      return -1;
    }

    return 0;
  }



   public void checkDup(){

     for(int i=0;i<(hand.size()-1);i++){
         int j=(i+1);
       while(hand.get(i).getValue()==hand.get(j).getValue()){

            if(hand.get(i).getSuit()==hand.get(j).getSuit()){
               throw new DuplicateCardException("DUPCARDS: "+hand.get(i).toString()+" "+hand.get(j).toString()); 
            } 

           j++;
         if(j==5){ break; }
         }
       
     }

   }

   public void getHand(){

    for(int i=0;i<hand.size();i++){

       System.out.print(hand.get(i).toString());

//       System.out.print(hand.get(i).rank+""+hand.get(i).suit+" ");
    } 
    
    System.out.println(); 
   }

/*
  @Override
  public int compareTo(PokerHand o) {
    // TODO Auto-generated method stub
    return 0;
  }
*/


  public int compareTo(PokerHand jam){

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
    int twtemp2=0;
    int twtemp=twokind();
    if(twtemp!=0){

       twtemp2=ntwokind(twtemp);

//System.out.println("test 22A "+twtemp+" "+twtemp2);       

         if(twtemp2!=0){ 
            val1=2;
         }else{val1=1;}
    } 

    int twtemp2jam=0;
    int twtempjam=jam.twokind();
    if(twtempjam!=0){

       twtemp2jam=jam.ntwokind(twtempjam);

// System.out.println("test 22B "+twtempjam+" "+twtemp2jam);        

         if(twtemp2jam!=0){ 
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
    int trtemp=threekind();
    int frtwtemp=0;

    if(trtemp!=0){

       frtwtemp=ntwokind(trtemp);
       
         if(frtwtemp!=0){ 
            val1=6;
         }else{val1=3;}
    } 

    int trtempjam=jam.threekind();
    int frtwtempjam=0;
    if(trtempjam!=0){

       frtwtempjam=jam.ntwokind(trtempjam);
       
         if(frtwtempjam!=0){ 
            val2=6;
         }else{val2=3;}
    } 



  // 4knd 
    int frtemp=fourkind();
    if(frtemp!=0){ val1=7;} 
    
    int frtempjam=jam.fourkind();
    if(frtempjam!=0){ val2=7;} 



  // straight flush
   if(straight()==1 && flush()==1){val1=8;}
   if(jam.straight()==1 && jam.flush()==1){val2=8;}

  // royal flush
   if(straight()==1 && flush()==1 && hand.get(4).getValue()==14){val1=9;}
   if(jam.straight()==1 && jam.flush()==1 && jam.hand.get(4).getValue()==14){val2=9;}




System.out.println("Vals: "+val1+" "+val2);


    if(val1>val2){ return 1;}
    if(val1<val2){ return -1;}

  // straight tie
    if(val1==4){

     if(highcrd(jam)==1){
       if(hand.get(3).getValue()!=5){
         return 1;}else{ return -1;}
     } 
     
    
     if(highcrd(jam)==-1){
      if(jam.hand.get(3).getValue()!=5){
         return -1;}else{ return 1;}
     }

     if(highcrd(jam)==0){ return 0;}

    }  


   // flush tie

   if(val1==5 || val1==7 || val1==8){
 
    if(highcrd(jam)==1){
       return 1;   
    }
     if(highcrd(jam)==-1){
       return -1;  
    }
   }

    // 4knd tie
    if(val1==7 && val2==7){
      if(frtemp>frtempjam){
         return 1;}
      if(frtemp<frtempjam){
         return -1;}
      if(frtemp==frtempjam){
         return 0;}
    }

    // flhs tie
    if(val1==6 && val2==6){
      if(trtemp>trtempjam){
         return 1;}
      if(trtemp<trtempjam){
         return -1;}
      if(trtemp==trtempjam){
         
         if(frtwtemp>frtwtempjam){
            return 1;}

         if(frtwtemp<frtwtempjam){
            return -1;}

         if(frtwtemp==frtwtempjam){
            return 0;}

       } 
    }   

    // 3 kind tie 
    if(val1==3 && val2==3){
      if(trtemp>trtempjam){
         return 1;}
      if(trtemp<trtempjam){
         return -1;}
      if(trtemp==trtempjam){
         return 0;}
    } 


    // 22 kind tie
System.out.println("test 22A "+twtemp+" "+twtemp2); 
System.out.println("test 22B "+twtempjam+" "+twtemp2jam);   
    if(twtemp2>twtemp2jam){ return 1;}
    if(twtemp2<twtemp2jam){ return -1;}
    if(twtemp2==twtemp2jam){ 
       if(twtemp>twtempjam){ return 1;}
       if(twtemp<twtempjam){ return -1;}
       if(twtemp==twtempjam){ return 0;}}
 // deal with high card for 22 same          


    // 2knd tie
    if(val1==1 && val2==1){
      if(twtemp>twtempjam){
         return 1;}
      if(twtemp<twtempjam){
         return -1;}
      if(twtemp==twtempjam){
         return 0;}
    } 
 


  return 0;



  }



   public int highcrd(PokerHand jam){

     for(int i=4;i>-1;i--){ 
    
       int retval=compareRank(hand.get(i),jam.hand.get(i));
 
       if(retval==1){
          return 1;
       }

       if(retval==-1){
          return -1;
       }


     }

     return 0;


   }

  
  public int fourkind(){

    int retval=0;

      if(hand.get(0).getValue()==hand.get(1).getValue() && hand.get(1).getValue()==hand.get(2).getValue() && hand.get(2).getValue()==hand.get(3).getValue()) {
        retval=hand.get(0).getValue();             
       }
        
       if(hand.get(1).getValue()==hand.get(2).getValue() && hand.get(2).getValue()==hand.get(3).getValue() && hand.get(3).getValue()==hand.get(4).getValue()){
        retval=hand.get(1).getValue();             
       }
      
     
     return retval;
  }

  public int threekind(){


    int retval=0;

      if(hand.get(0).getValue()==hand.get(1).getValue() && hand.get(1).getValue()==hand.get(2).getValue()) {
        retval=hand.get(0).getValue();             
       }
 
      if(hand.get(1).getValue()==hand.get(2).getValue() && hand.get(2).getValue()==hand.get(3).getValue()) {
        retval=hand.get(1).getValue();             
       }
 
      if(hand.get(2).getValue()==hand.get(3).getValue() && hand.get(3).getValue()==hand.get(4).getValue()) {
        retval=hand.get(2).getValue();             
       }
 
    return retval;
  }



  public int twokind(){

    int cnt=0;
    int retval=0;

    for(int i=0;i<4;i++){

      if(hand.get(i).getValue()==hand.get(i+1).getValue()){
        retval=hand.get(i).getValue();
        cnt++;
      }
      
    }
   
    if(cnt==1){ return retval;}
    
    return retval;
  }


  public int ntwokind(int jump){

    int cnt=0;
    int retval=0;


    for(int i=0;i<4;i++){
      
     if(hand.get(i).getValue()==jump){
      continue; 
      }


      if(hand.get(i).getValue()==hand.get(i+1).getValue()){
        retval=hand.get(i).getValue(); 
        cnt++;
      }
      
    }
   
    if(cnt==1){ return retval;}
    
    return retval;
  }



 
  public int flush(){
  
    int cnt=0;

    for(int i=0;i<4;i++){

      if(hand.get(i).getSuit()==hand.get(i+1).getSuit()){
        cnt++;
      }
      
    }

   if(cnt==4){return 1;} 

   return 0;
  }

  public int straight(){

  // test for ace low straight
   if(hand.get(0).getValue()==2 && hand.get(1).getValue()==3 && hand.get(2).getValue()==4 && hand.get(3).getValue()==5 && hand.get(4).getValue()==14) { return 1;}
 
   for(int i=0;i<4;i++){

      if((hand.get(i+1).getValue()-hand.get(i).getValue())!=1){
        return 0;
      }

    }

     return 1;
 
   }
   
 


}
