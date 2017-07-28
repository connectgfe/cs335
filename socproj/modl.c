#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main(){


 double x =1;
 int in;
 long val;
 int arr[10];
 int cnt=0;
 int mult=0;
 int mod=197;


 while(x<11){
  
 val = (long)pow(11.0,x);  
 in= val % mod;
 arr[cnt]=in; 
 printf("val is :%d %lu %f\n",in, val,x);
 x++;
 cnt++;
 }
 
  mult=arr[9];

 for(int i=0;i<10;i++){
//  printf("arrval: %d %d\n",arr[i],mult);
 }



 int j=0;
 cnt++;
 int val2=0;
 while(val2==0){


 for(j=0;j<10;j++){ 
  arr[j]=(arr[j]*mult % mod);

  if( arr[j]==110){
   val2=cnt;
   printf("val is %d\n",val2);
   break;
   } 
 
  // printf("arrval#: %d %d\n",arr[j],cnt); 
 
 cnt++;
 }


 }



}
