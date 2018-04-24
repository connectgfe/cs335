function [ret]=parse_1(X,col1,col2,v1,v2)

%ret=0;
m=size(X,1);


k=1;

%for i=1:m; if (X(i,col)>=low && X(i,col)<=high); ret=ret+1; end; end; 

for i=1:m; if (X(i,col1)==v1 && X(i,col2)==v2); ret(k,:)=X(i,:); k=k+1; end; end; 

%for i=1:m; ret(i,1)= X(i,2)-120;  ret(i,2)= X(i,3)-80; end; 


