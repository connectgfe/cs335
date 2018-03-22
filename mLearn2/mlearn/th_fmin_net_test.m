function [jVal,gradientVec] = fmin_net_test(thetaVec,X,y)

l1=28;
l2=5;
l3=5;

end1=(l2-1)*l1;
beg2=end1+1;
end2=beg2+(l3-1)*l2-1;
beg3=end2+1;
end3=beg3+l3-1;

the1=reshape(thetaVec(1:end1),l2-1,l1);
the2=reshape(thetaVec(beg2:end2),l3-1,l2);
the3=reshape(thetaVec(beg3:end3),1,l3);



%the1=reshape(thetaVec(1:56),2,28);
%the2=reshape(thetaVec(57:62),2,3);
%the3=reshape(thetaVec(63:65),1,3);

m = size(X,1);
hx=zeros(m,1);
a3=zeros(l3,m);
a2=zeros(l2,m);


for i=1:m; a2(:,i) = [1; sigmoid(the1*X(i,:)')]; a3(:,i) = [1; sigmoid(the2*a2(:,i))];  hx(i) = sigmoid(the3*a3(:,i)); end;

jVal = -(1./m).*(sum(y.*(log(hx))+(1-y).*(log(1-hx))));


d4 = hx-y;

%calc bd3
temp_bd3 = ((a3'.*d4)'*ones(m,1));
bd3 = temp_bd3';

d3 = (((a3.*d4').*the3').*(1-a3));
d3(1,:)=[];

%calc bd2
bd2=zeros(l3-1,l2);
for i=1:m; bd2 = bd2 + d3(:,i)*(a2(:,i)');end;
 
%  temp_bd2 = ((a2'.*d3)'*ones(m,1));
%  bd2 = temp_bd2';
d2=zeros(l2,m);
for i=1:m, d2(:,i) = (the2'*d3(:,i)).*a2(:,i).*(1-a2(:,i));end;
%  d2 = (((a2.*d3').*the2').*(1-a2));
d2(1,:)=[];

%calc bd1
bd1=zeros(l2-1,l1);
for i=1:m; bd1 = bd1 + d2(:,i)*(X(i,:));end;
 
gradient1 = (1./m).*bd1;
gradient2 = (1./m).*bd2;
gradient3 = (1./m).*bd3;
gradientVec=[gradient1(:);gradient2(:);gradient3(:)];

