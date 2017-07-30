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
 mpz_init_set_str(mod,"182828394971",10);
 

 mpz_init_set_str(alpha,"",10);
// double ppr=(double)atoi(argv[1]);
 mpz_init_set_str(beta,"13741",10);
// long log=atoi(argv[2]);

// printf("%f^x = %lu mod %llu\n",ppr,log,mod);


// exit(0);


// double x =1;
 long long in=182828394971;
// long long val;
// long long arr[10];


 long long mult=0;
 
 int i=0;
// manually fill array

 void **nums=(void**)malloc(10*sizeof(void*));

 mpz_t two,three,four,five,six,seven,eight,nine,ten;
 mpz_t val2,val3,val4,val5,val6,val7,val8,val9,val10,spc10;

 mpz_init(val2);
 mpz_init(val3);
 mpz_init(val4);
 mpz_init(val5);
 mpz_init(val6);
 mpz_init(val7);
 mpz_init(val8);
 mpz_init(val9);
 mpz_init(val10);
 mpz_init(spc10);

 //mpz_init(val2); mpz_init(val3);
 mpz_init_set_str(two,"2",10); 
 mpz_init_set_str(three,"3",10); 
 mpz_init_set_str(four,"4",10); 
 mpz_init_set_str(five,"5",10); 
 mpz_init_set_str(six,"6",10); 
 mpz_init_set_str(seven,"7",10); 
 mpz_init_set_str(eight,"8",10); 
 mpz_init_set_str(nine,"9",10); 
 mpz_init_set_str(ten,"10",10); 


  *nums=alpha;

  mpz_powm(val2,alpha,two,mod);
  *(nums+1)=val2;

  mpz_powm(val3,alpha,three,mod);
  *(nums+2)=val3;

  mpz_powm(val4,alpha,four,mod);
 *(nums+3)=val4;

  mpz_powm(val5,alpha,five,mod);
 *(nums+4)=val5;

  mpz_powm(val6,alpha,six,mod);
 *(nums+5)=val6;

  mpz_powm(val7,alpha,seven,mod);
 *(nums+6)=val7;

  mpz_powm(val8,alpha,eight,mod);
 *(nums+7)=val8;

  mpz_powm(val9,alpha,nine,mod);
 *(nums+8)=val9;

  mpz_powm(val10,alpha,ten,mod);
 *(nums+9)=val10;

  mpz_powm(spc10,alpha,ten,mod);

/*
 while(i<10){
 mpz_out_str(stdout,10,*(nums+i));
 printf("\n");
 i++;
 }
*/

 long long cnt=11;
 long long getval=0;

 while(getval==0){
  
   for(i=0;i<10;i++){
    mpz_mul(*(nums+i),spc10,*(nums+i));
    mpz_mod(*(nums+i),*(nums+i),mod);

//mpz_out_str(stdout,10,*(nums+i));
//printf("\n");
 
     if( mpz_cmp(*(nums+i),beta)==0){ 
       getval=cnt;
       printf("found it %llu\n",getval);
       exit(0); 
     }
   
    cnt++;
//  if(cnt>130){exit(0);}

   }

 
 } 

/*
 printf("\n");

 int j=0;
 while(j<10){
 mpz_out_str(stdout,10,*(nums+j));
 printf("\n");
 j++;
 }
*/

/*

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

*/

}
