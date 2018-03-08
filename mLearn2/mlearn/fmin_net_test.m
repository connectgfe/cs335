function [jVal,gradientVec] = fmin_net_test(thetaVec,X,y)


the1=reshape(thetaVec(1:6),2,3);
the2=reshape(thetaVec(7:9),1,3);

m = size(X,1);
hx=zeros(m,1);
a2=zeros(3,m);

for i=1:m; a2(:,i) = [1; sigmoid(the1*X(i,:)')]; hx(i) = sigmoid(the2*a2(:,i)); end;

jVal = -(1./m).*sum(y.*(log(hx))+(1-y).*(log(1-hx)));

d3 = hx-y;
temp_bd2 = ((a2'.*d3)'*ones(m,1));
bd2 = temp_bd2';

d2 = (((a2.*d3').*the2').*(1-a2));
d2(1,:)=[];

%d2 = the2'*d3.*a2.*(1-a2);
%d2 = [d2(2,1); d2(3,1);d2(4,1)];
bd1=zeros(2,3);
for i=1:m; bd1 = bd1 + d2(:,i)*(X(i,:));end;
 
%bd2  = bd2 + d3*a2';
%bd1  = bd1 + d2*(X(i,:)); 

gradient1 = (1./m).*bd1;
gradient2 = (1./m).*bd2;
gradientVec=[gradient1(:);gradient2(:)],
 
%bd1=0;
%bd2=0;


%for j=1:10000;  for i=1:size(X,1),  a2 = [1; sigmoid(the1*X(i,:)')], hx = sigmoid(the2*a2), d3 = hx-y(i), d2 = the2'*d3.*a2.*(1-a2), d2 = [d2(2,1); d2(3,1);d2(4,1)], bd2 = bd2 + d3*a2', bd1 = bd1 + d2*(X(i,:)), end; disp('endinnerloop'),the1 = the1 - (1/9)*bd1, the2 = the2 - (1/9)*bd2,   bd1=zeros(3,8); bd2= zeros(1,4); end;


