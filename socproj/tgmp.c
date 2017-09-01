#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>


int main(){

   void **vals=(void**)malloc(10*sizeof(mpz_size));
   mpz_t var1, var2, var3;

   mpz_init_set_str(var1,"100438483843874384338484398439843988387437373874343743878743874373732763262632637632763276327627632763276327632763276327632763764748738743878743874387438743743874387438743878737273732873287327328732873287328732873287328732873287328743843984398439843984398439843984398439843984398439843984383272721762176217600",10);     
   mpz_init_set_str(var2,"100000000021872873232732873287328728728732873272376327623762176327632873276327327632873287328329832982192093298329832982982983298329832983209327474763763",10);  

    mpz_init(var3);
   *vals=var3;

   *(vals+1)=var2;
   *(vals+2)=var1;
 
   mpz_out_str(stdout,10,*vals);
   printf("\n");
   mpz_out_str(stdout,10,*(vals+1));
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

