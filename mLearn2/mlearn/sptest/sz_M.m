function[M,N]=sz_M(X,y,sz)

m=size(X,1);
val=m-sz;

M=zeros(sz,26);
%M=zeros(sz,51);
N=zeros(sz,1);


for i=1:sz; M(i,:)=X(val+i,:); N(i)=y(val+i); end;



