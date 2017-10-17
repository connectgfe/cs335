//package model;
import java.io.*;
import java.time.LocalDate;


public class User implements Serializable{

     public String name;
     public String password;
     public double totalMinUsed;
     public String song1, song2, song3;
     public LocalDate firstPlay, dateJoined;

   public User(String name, String password, LocalDate dateJoined){
 
     totalMinUsed = 0.0; 
     this.name = name; 
     this.password = password;
     this.dateJoined = dateJoined; 
     firstPlay=dateJoined;
     song1= "(song 1)";
     song2= "(song 2)";
     song3= "(song 3)";
      
   }

   public String getName(){
     return name;
   } 

   public String getPassword(){
     return password;
   } 

   public String getMins(){

     return String.valueOf(totalMinUsed);
   }

   public void setMins(Double addMins){
   
     totalMinUsed = addMins+totalMinUsed; 

   }

   public void setSongOne(String song, LocalDate firstPlay){

     song1 =  song;
     this.firstPlay = firstPlay;
 
   }

   public void setSongTwo(String song){

     song2 =  song;
   }

   public void setSongThree(String song){

     song3 =  song;
   }

   public String getSongOne(){
 
      return song1; 
   }

   public String getSongTwo(){
 
      return song2; 
   }

   public String getSongThree(){
 
      return song3; 
   }

   public void resetPlays(){

     song1= "(song 1)";
     song2= "(song 2)";
     song3= "(song 3)";
    

   }

   public void setPlays(LocalDate firstPlay){

      this.firstPlay = firstPlay; 
   }



}
