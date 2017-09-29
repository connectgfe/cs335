#include <stdlib.h>
#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>



  int main(){



  char buf[15];


  int fd1= open("test1.html", O_RDONLY);
  int val1=  read(fd1,buf,15);

  printf("%s\n",buf);


    return 0;
  }
