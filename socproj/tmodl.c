#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <gmp.h>


int main(int argc, char *argv[]){

 

// printf("%s %s %s\n",argv[1],argv[2],argv[3]);

// long long mod=(long long)atoi(argv[3]);
// long long mod=182828394773;
 mpz_t mod, beta, alpha, x;
 mpz_init(x);
 mpz_init_set_str(mod,"182828394773",10);
 mpz_init_set_str(alpha,"14",10);
// double ppr=(double)atoi(argv[1]);
 mpz_init_set_str(beta,"993843939",10);
// long log=atoi(argv[2]);

// printf("%f^x = %lu mod %llu\n",ppr,log,mod);


// exit(0);
 mpz_t tens;
 mpz_init_set_str(tens,"11",10);

 double x =1;
 long long in;
 long long val;
 long long arr[10];
 long long cnt=0;
 long long mult=0;


/*
 int mod=13469;
 double ppr=17.0;
 int log=12031;
*/
 while(mpz_cmp(x<tens)){
// while(x<11){
  
 val = (long long)pow(ppr,x);  
 in= val % mod;
 arr[cnt]=in; 
 printf("val is :%llu %llu %f\n",in, val,x);
 x++;
 cnt++;
 }
 
  mult=arr[9];

 for(int i=0;i<10;i++){
//  printf("arrval: %d %d\n",arr[i],mult);
 }



 int j=0;
 cnt++;
 long long val2=0;
 while(val2==0){


    for(j=0;j<10;j++){ 
     arr[j]=((arr[j]*mult) % mod);

      if( arr[j]==log){
       val2=cnt;
       printf("x is %llu\n",val2);
       break;
      } 
      if(cnt<50){ 
   printf("arrval#: %llu %llu\n",arr[j],cnt); 
      } 
     cnt++;

      if(cnt==mod){
       printf("count reached: %llu\n",cnt); 
       exit(0);
      }
    
   }


  }



}
