#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <time.h> 

void connected();
int connfd;

int main(int argc, char *argv[])
{
    int listenfd = 0;
    connfd = 0;
    struct sockaddr_in serv_addr; 

    char sendBuff[1025];
    time_t ticks; 

    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof(serv_addr));
    memset(sendBuff, '0', sizeof(sendBuff)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(5000); 


    bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)); 

    listen(listenfd, 10); 

    while(1)
    {
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 



        connected();

        ticks = time(NULL);
        snprintf(sendBuff, sizeof(sendBuff), "%.24s\r\n", ctime(&ticks));
        write(connfd, sendBuff, strlen(sendBuff)); 


  //      close(connfd);
        sleep(1);
     }
}

void connected(){


      char* hello= "Username: "; 
      write(connfd, hello, strlen(hello));
      sleep(3);      
       char line[15]; 
      memset(line, '0', sizeof(line)); 

      read(connfd,line,strlen(line));
     write(connfd, line, strlen(line));




/*
    
      char line[125]; 
      memset(line, '0', sizeof(line)); 

      read(connfd,line,strlen(line));

      if(line[0]!='\0'){


      write(connfd, line, strlen(line));

      }
*/

/*
      int val;

      char* line;
      size_t len=0;

      while(val>1){   
   
      



       val=getline(&line,&len,stdin);

      write(connfd, line, strlen(line));

      }
*/

}
