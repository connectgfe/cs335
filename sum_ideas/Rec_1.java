


public class Rec_1{


  public static int cnt;



  public static void main(String[] args){


  int[] list_1 = {1,2,3,4,5};
  int[] list_2 = new int[5];

  cnt=0;


  fun(list_2,list_1,0);

  System.out.println(cnt);


  }



  public static void fun(int[] x, int[] list,int pos){


   cnt++;
//   print_arr(x);


   if(x[list.length-1]!=0){ 

//   System.out.println("doing ret");
   return;}


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



