


public class Rec_1{



  public static void main(String[] args){


  int[] list_1 = {1,2,3,4};
  int[] list_2 = new int[4];

//  int[] list_2 = {2,3,1,0};

//  System.out.println(add(list_2,list_1));



  fun(list_2,list_1,0);

  }



  public static void fun(int[] x, int[] list,int pos){


   print_arr(x);


   if(x[3]!=0){ 

//   System.out.println("doing ret");


   return;}

/*
     for(int j=0;j<list.length;j++){ 

//  add list to x
        if(x[j]!=list[j]){
        x[j]=list[j];
        }
*/

       for(int i=0;i<list.length;i++){ 

         if(x[i]==list[i]){ 
//           pos++;
//        System.out.print("in ");
//        print_arr(x);


         continue;}


         if(check(x,list[i])==0){


         x[pos]=list[i];
//         if(x[i]==0){
//         x[++pos]=add(x,list);

//         if(x[pos]==0){ pos--;}
      
         fun(x,list,++pos);
// set to 0         

         pos--;        

         x[pos]=0;

         }

//         continue;
//         }

//   print_arr(x);



    
//          pos--;

       }

//       x=set_zero(x.length);
       

 
//     }


//   print_arr(x);



  }


 public static int check(int[] x, int val){

  for(int i=0;i<x.length;i++){

    if(x[i]==val){ return 1; }

  }

  
  return 0;

 }



 public static int add(int[] x, int[] list){

  int cnt=0;

  for(int i=0;i<list.length;i++){

   for(int j=0;j<list.length;j++){
  

     if(x[j]==list[i]){

     cnt++;

     }

   } 

   if(cnt==0){return list[i];}

   cnt=0;

//   print_arr(x);



  }


  System.out.println("sending zero");

  return 0;


 }




 public static int[] set_zero(int len){

   return new int[len];


 }


 public static void print_arr(int[] x){

   for(int i=0;i<x.length;i++){

      System.out.print(x[i]+" ");

   }

     System.out.println(); 


 }





}



