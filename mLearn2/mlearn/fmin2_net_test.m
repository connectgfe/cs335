function [jVal,gradientVec] = fmin2_net_test(thetaVec,X,y)


the1=reshape(thetaVec(1:10),2,5);
the2=reshape(thetaVec(11:16),2,3);
the3=reshape(thetaVec(17:19),1,3);

m = size(X,1);
hx=zeros(m,1);
a3=zeros(3,m);
a2=zeros(3,m);

lam=.001;

for i=1:m; a2(:,i) = [1; sigmoid(the1*X(i,:)')]; a3(:,i) = [1; sigmoid(the2*a2(:,i))];  hx(i) = sigmoid(the3*a3(:,i)); end;
jVal = -(1./m).*sum(y.*(log(hx))+(1-y).*(log(1-hx)))+(lam/(2*m)).*sum(thetaVec.*thetaVec);


d4 = hx-y;

%calc bd3
temp_bd3 = ((a3'.*d4)'*ones(m,1));
bd3 = temp_bd3';

d3 = (((a3.*d4').*the3').*(1-a3));
d3(1,:)=[];

%calc bd2
bd2=zeros(2,3);
for i=1:m; bd2 = bd2 + d3(:,i)*(a2(:,i)');end;
 
%  temp_bd2 = ((a2'.*d3)'*ones(m,1));
%  bd2 = temp_bd2';
d2=zeros(3,m);
for i=1:m, d2(:,i) = (the2'*d3(:,i)).*a2(:,i).*(1-a2(:,i));end;
%  d2 = (((a2.*d3').*the2').*(1-a2));
d2(1,:)=[];

%calc bd1
bd1=zeros(2,5);
for i=1:m; bd1 = bd1 + d2(:,i)*(X(i,:));end;
 
gradient1 = (1./m).*(bd1 + lam*the1);
gradient2 = (1./m).*(bd2 + lam*the2);
gradient3 = (1./m).*(bd3 + lam*the3);
gradientVec=[gradient1(:);gradient2(:);gradient3(:)];

