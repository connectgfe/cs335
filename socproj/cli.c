#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h> 

void comm(int);
char *hostname;



int main(int argc, char *argv[])
{
    int sockfd = 0, n = 0;
    char recvBuff[1024];
    struct sockaddr_in serv_addr; 

    hostname=argv[1];
    printf("%s\n",hostname);


    if(argc != 2)
    {
        printf("\n Usage: %s <ip of server> \n",argv[0]);
        return 1;
    } 

    memset(recvBuff, '0',sizeof(recvBuff));
    if((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Error : Could not create socket \n");
        return 1;
    } 

    memset(&serv_addr, '0', sizeof(serv_addr)); 

    serv_addr.sin_family = AF_INET;

    // assigned port
    serv_addr.sin_port = htons(80); 


    // assigned address
    if(inet_pton(AF_INET, argv[1], &serv_addr.sin_addr)<=0)
    {
        printf("\n inet_pton error occured\n");
        return 1;
    }

printf("no1\n");

    // new socket sockfd
    if( connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
       printf("\n Error : Connect Failed \n");
       return 1;
    } 
printf("no2\n");

    comm(sockfd);

    while ( (n = read(sockfd, recvBuff, sizeof(recvBuff)-1)) > 0)
    {
   
printf("no3\n");
     recvBuff[n] = 0;
     
       if(fputs(recvBuff, stdout) != EOF){
         
printf("recvBuff: %s\n",recvBuff);        

//        comm(sockfd);
/* 
        char* line="msg recieved";
         char* line2="sent msg";
         //printf("%s\n",line);

         write(sockfd, line, strlen(line));
//    printf("%s\n",line2);
*/
 
        }else{


            printf("\n Error : Fputs error\n");
        }
 
       


    } 

    if(n < 0)
    {
        printf("\n Read error \n");
    } 

    return 0;
} 


void comm(int fd){

 
  char *line;
  size_t len=0;

  char buf[30000];
  int bytes;

  char msg[50]="GET / HTTP/1.1\r\nHost: ";
  strcat(msg,hostname);

//     char *end="\r\n\r\n";

//     char *end="\r\nUser-Agent: Mozilla/5.0\r\nAccept: text/xml,application/xml,application/xhtml+xml,text/html*/*\r\nAccept-Language: en-us\r\nAccept-Charset: ISO-8859-1,utf-8\r\nConnection: keep-alive\r\n\r\n";

     char *end="\r\nUser-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36\r\nAccept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\nAccept-Language: en-US,en;q=0.8\r\nAccept-Encoding: gzip, deflate\r\nConnection: keep-alive\r\n\r\n";

     strcat(msg,end);

     printf("%s",msg);


//        char *msg = "Begin Transmission\n";
 
     write(fd, msg, strlen(msg));  

    while( bytes= read(fd,buf,sizeof(buf))>0){


    buf[bytes]=0;

    printf("%s\n",buf);

    printf("end input\n");
     
    }
/*
 
  while(getline(&line,&len,stdin)>0){


   printf("sending\n");
   write(fd,line,strlen(line));
   
   sleep(1);
   char rec[15]; 
   memset(rec,'0',sizeof(rec));

   read(fd,rec,15);
   

   for(int i=0;i<15;i++){
    if(rec[i]=='0'){ rec[i]='\0';}
   }
 

   if(!strcmp(rec,"Confirmed")){
    printf("Success\n");
    exit(1);
   }
  
   printf("from serv %s\n",rec);
   
   sleep(1);
  
  }

*/


}

