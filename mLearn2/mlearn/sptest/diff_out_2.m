function [ val]=diff_out_2(M,N,O,X,y,m)

hx=zeros(m,1);
d_2=zeros(m,1);
D=zeros(m,2);
d_y=zeros(m,1);



for i=1:m ; hx(i)=neur2_hyp(M,N,O,X(i,:)); end;

for i=1:m ; d_2(i)=abs(y(i)-hx(i)); d_y(i)=y(i);end;


D=[hx d_y d_2];
val=sum(d_2)./m;

