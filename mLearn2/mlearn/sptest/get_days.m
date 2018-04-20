function [y]=get_days(X,y)


%m=size(X,1)/5;

%for i=0:m; if X(((i+1)*5),1)- X((i*5)+1,1) !=4, val = i; break; end; end;


%val=zeros(795,1);


for i=1:794 ; 

 if X(795-i,2)==0;
 
   y(795-i)=[];
 end;
end;   
 


%val(i)= (1+mod(i-1,5)) ; end;

