#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>


int main(){

  void **vals=(void**)malloc(10*sizeof(void*));
  
   mpz_t alpha, x, beta, mod;

   mpz_init_set_str(alpha,"3242736143229285405697273596419677873912657748731448981302390864459158863881443495029809033284732127",10);
  
   mpz_init_set_str(x,"3484843874387387874387238738723983298732987329832",10);
 
   mpz_init(beta);

//   mpz_init_set_str(mod,"7243469162906133262707138361729247674528418426076702186281286038623238274842547507072974617594640311",10);

   mpz_init_set_str(mod,"4640311",10);




   mpz_powm(beta,alpha,x,mod);



  mpz_out_str(stdout,10,beta);
   printf("\n");


/*
   mpz_mod(var3,var1,var2);

   mpz_out_str(stdout,10,var3);
   printf("\n");

   *vals=var3;
   *(vals+1)=var2;
   *(vals+2)=var1;
   mpz_powm(*vals,*(vals+1),*(vals+2),var1);

   mpz_out_str(stdout,10,*vals);
   printf("\n");
   mpz_out_str(stdout,10,*vals+1);

*/

 //  printf("%s\n",vals);

}


