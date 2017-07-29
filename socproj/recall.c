#include <stdlib.h>
#include <stdio.h>


int main(){


  char **arr=(char**)malloc(10*sizeof(char*));
  *arr="1111111111";
  *(arr+1)="2222222222";

  printf("%s %s\n",*arr,*(arr+1)); 


}
