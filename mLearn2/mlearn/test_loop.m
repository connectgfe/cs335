function [the1,the2,d3,d2] = test_loop(X,y)

the1= [ 1/87 1/3 1/32 1/34 1/23 1/4 1/3 1/2   ; 
         1/2 1/ 56 1/34 1/23 1/6 1/5 1/3    1/23;
         1/4 1/2 1/45 1/4 1/45 1/89 1/43  1/45]; 
the2= [ 1/3 1/6 1/8 1/4 ];

bd1=0;
bd2=0;


for j=1:10000;  for i=1:size(X,1),  a2 = [1; sigmoid(the1*X(i,:)')], hx = sigmoid(the2*a2), d3 = hx-y(i), d2 = the2'*d3.*a2.*(1-a2), d2 = [d2(2,1); d2(3,1);d2(4,1)], bd2 = bd2 + d3*a2', bd1 = bd1 + d2*(X(i,:)), end; disp('endinnerloop'),the1 = the1 - (1/9)*bd1, the2 = the2 - (1/9)*bd2,   bd1=zeros(3,8); bd2= zeros(1,4); end;


