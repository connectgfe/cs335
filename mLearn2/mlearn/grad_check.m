function [bD,diff] = grad_check(thetaVec,X,y)


the1=reshape(thetaVec(1:10),2,5);
the2=reshape(thetaVec(11:13),1,3);

k = size(thetaVec,1);
diff = zeros(k,1);
m = size(X,1);
Hx=zeros(m,1);
a2=zeros(3,m);
bd1=0;
bd2=0;
e=.1;
lam=1;

%compute grad
for i=1:m; a2 = [1; sigmoid(the1*X(i,:)')]; hx = sigmoid(the2*a2); d3 = hx-y(i); d2 = the2'*d3.*a2.*(1-a2); d2 = [d2(2,1); d2(3,1)]; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end; 

D1=(1/m).*(bd1 + lam*the1); D2=(1/m).*(bd2 + lam*the2);

bD=[D1(:);D2(:)];


%roll up theta add e, unroll theta
for j=1:k; tmp_thetaVec=[the1(:);the2(:)]; regVal = tmp_thetaVec(j); tmp_thetaVec(j)=tmp_thetaVec(j)+e;  tmp_the1=reshape(tmp_thetaVec(1:10),2,5); tmp_the2=reshape(tmp_thetaVec(11:13),1,3);

sum(tmp_thetaVec);

%comupte each hx
for i=1:m; a2(:,i) = [1; sigmoid(tmp_the1*X(i,:)')]; Hx(i) = sigmoid(tmp_the2*a2(:,i)); end;

jVal_pe = -(1./m).*sum(y.*(log(Hx))+(1-y).*(log(1-Hx))) +(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);


tmp_thetaVec=[the1(:);the2(:)]; tmp_thetaVec(j)=tmp_thetaVec(j)-e; tmp_the1=reshape(tmp_thetaVec(1:10),2,5); tmp_the2=reshape(tmp_thetaVec(11:13),1,3);

sum(tmp_thetaVec);


%comupte each hx
for i=1:m; a2(:,i) = [1; sigmoid(tmp_the1*X(i,:)')]; Hx(i) = sigmoid(tmp_the2*a2(:,i)); end;

jVal_me = -(1./m).*sum(y.*(log(Hx))+(1-y).*(log(1-Hx))) +(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);


diff(j) = (jVal_pe - jVal_me)./(2*e);

end;


