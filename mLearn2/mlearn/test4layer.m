function [the1,the2,the3] = test4layer(X,y)



the1= [ 1/5  1/2 1/4 1/5 1/4; 1/5 1/9 1/4 1/5 1/9];

the2= [ 1/4  1/5 1/9; 1/4 1/3 1/6 ];

the3= [ 1/9 1/2 1/9];


bd1=0;
bd2=0;
bd3=0;

for j=1:500;  for i=1:size(X,1);  a2 = [1; sigmoid(the1*X(i,:)')]; a3 = [1; sigmoid(the2*a2)]; hx = sigmoid(the3*a3); d4 = hx-y(i), d3 = the3'*d4.*a3.*(1-a3),  d3 = [d3(2,1); d3(3,1)],  d2 = the2'*d3.*a2.*(1-a2), d2 = [d2(2,1); d2(3,1)]; bd3 = bd3 + d4*a3'; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end; disp('endinnerloop'); the1 = the1 - (1/4)*bd1; the2 = the2 - (1/4)*bd2;  the3 = the3 - (1/4)*bd3; bd1=zeros(2,5); bd2=zeros(2,3); bd3= zeros(1,3); end;


