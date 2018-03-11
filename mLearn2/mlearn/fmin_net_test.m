function [jVal,gradientVec] = fmin_net_test(thetaVec,X,y)


the1=reshape(thetaVec(1:10),2,5);
the2=reshape(thetaVec(11:13),1,3);

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

bd1=zeros(2,5);
for i=1:m; bd1 = bd1 + d2(:,i)*(X(i,:));end;
 

gradient1 = (1./m).*bd1;
gradient2 = (1./m).*bd2;
gradientVec=[gradient1(:);gradient2(:)];
 

