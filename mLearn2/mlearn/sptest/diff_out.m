function [val]=diff_out(M,N,O,X,y,t)

m=size(X,1);
hx=zeros(m-t,1);
d_2=zeros(m-t,1);
D=zeros(m-t,3);
d_y=zeros(m-t,1);




for i=1:m-t ; hx(i)=neur2_hyp(M,N,O,X(i+t,:)); end;

for i=1:m-t ; d_2(i)=abs(y(i+t)-hx(i)); d_y(i)=y(i+t); end;



D=[hx d_y d_2];
val=sum(D(:,3))/size(D,1);

