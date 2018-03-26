function [the1,the2,the3,jVal_diff] = test4layer(thetaVec,X,y)

m=size(X,1);

the1=reshape(thetaVec(1:10),2,5);
the2=reshape(thetaVec(11:16),2,3);
the3=reshape(thetaVec(17:19),1,3);


%the1= [ 1/5  1/2 1/4 1/5 1/4; 1/5 1/9 1/4 1/5 1/9];

%the2= [ 1/4  1/5 1/9; 1/4 1/3 1/6 ];

%the3= [ 1/9 1/2 1/9];

bd1=0;
bd2=0;
bd3=0;

Hx_a=zeros(m,1);
Hx_b=zeros(m,1);


lam = .001;


jVal_diff=1;

%for j=1:1000;

while jVal_diff>.0000001;

 for i=1:size(X,1);  a2 = [1; sigmoid(the1*X(i,:)')]; a3 = [1; sigmoid(the2*a2)]; hx = sigmoid(the3*a3); d4 = hx-y(i); d3 = the3'*d4.*a3.*(1-a3);  d3 = [d3(2,1); d3(3,1)];  d2 = the2'*d3.*a2.*(1-a2); d2 = [d2(2,1); d2(3,1)]; bd3 = bd3 + d4*a3'; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end;  

% calc jVal pre update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_a(k) = sigmoid(the3*A3(:,k)); end;

jVal_a = -(1./m).*sum(y.*(log(Hx_a))+(1-y).*(log(1-Hx_a)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);

% update the
the1 = the1 - (1/m)*(bd1 + lam*the1); the2 = the2 - (1/m)*(bd2 + lam*the2);  the3 = the3 - (1/m)*(bd3 + lam*the3); bd1=zeros(2,5); bd2=zeros(2,3); bd3= zeros(1,3); 

% calc jVal post update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_b(k) = sigmoid(the3*A3(:,k)); end;

jVal_b = -(1./m).*sum(y.*(log(Hx_b))+(1-y).*(log(1-Hx_b)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);


jVal_diff = jVal_a - jVal_b;

end;


