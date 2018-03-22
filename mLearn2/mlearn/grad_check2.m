function [bD,diff] = grad_check2(thetaVec,X,y)


the1=reshape(thetaVec(1:10),2,5);
the2=reshape(thetaVec(11:16),2,3);
the3=reshape(thetaVec(17:19),1,3);

k = size(thetaVec,1);
diff = zeros(k,1);
m = size(X,1);
Hx=zeros(m,1);
a2=zeros(3,m);
a3=zeros(3,m);
bd1=0;
bd2=0;
bd3=0;
e=.1;


%compute grad
for i=1:m;  a2 = [1; sigmoid(the1*X(i,:)')]; a3 = [1; sigmoid(the2*a2)]; hx = sigmoid(the3*a3); d4 = hx-y(i); d3 = the3'*d4.*a3.*(1-a3);  d3 = [d3(2,1); d3(3,1)];  d2 = the2'*d3.*a2.*(1-a2); d2 = [d2(2,1); d2(3,1)]; bd3 = bd3 + d4*a3'; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end; 

D1=(1/m).*bd1; D2=(1/m).*bd2; D3=(1/m).*bd3;

bD=[D1(:);D2(:);D3(:)];


%roll up theta add e, unroll theta
for j=1:k; tmp_thetaVec=[the1(:);the2(:);the3(:)]; tmp_thetaVec(j)=tmp_thetaVec(j)+e;  tmp_the1=reshape(tmp_thetaVec(1:10),2,5); tmp_the2=reshape(tmp_thetaVec(11:16),2,3); tmp_the3=reshape(tmp_thetaVec(17:19),1,3);

%comupte each hx
for i=1:m; a2(:,i) = [1; sigmoid(tmp_the1*X(i,:)')]; a3(:,i) = [1; sigmoid(tmp_the2*a2(:,i))];  Hx(i) = sigmoid(tmp_the3*a3(:,i)); end;

jVal_pe = -(1./m).*sum(y.*(log(Hx))+(1-y).*(log(1-Hx)));


 tmp_thetaVec=[the1(:);the2(:);the3(:)]; tmp_thetaVec(j)=tmp_thetaVec(j)-e;  tmp_the1=reshape(tmp_thetaVec(1:10),2,5); tmp_the2=reshape(tmp_thetaVec(11:16),2,3); tmp_the3=reshape(tmp_thetaVec(17:19),1,3);

%comupte each hx
for i=1:m; a2(:,i) = [1; sigmoid(tmp_the1*X(i,:)')]; a3(:,i) = [1; sigmoid(tmp_the2*a2(:,i))];  Hx(i) = sigmoid(tmp_the3*a3(:,i)); end;

jVal_me = -(1./m).*sum(y.*(log(Hx))+(1-y).*(log(1-Hx)));

diff(j) = (jVal_pe - jVal_me)./(2*e);

end;
