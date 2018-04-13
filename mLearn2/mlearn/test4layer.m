function [the1,the2,the3,jVal_diff,lam] = test4layer(thetaVec,X,y,lam)

tmp_X=X;
tmp_y=y;

X([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30],:)=[];
y([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30],:)=[];


%X([1,2,3,4,5,6,7,8,9,10],:)=[];
%y([1,2,3,4,5,6,7,8,9,10],:)=[];




m=size(X,1);

%the1=reshape(thetaVec(1:684),9,76);
%the2=reshape(thetaVec(685:774),9,10);
%the3=reshape(thetaVec(775:784),1,10);

the1=reshape(thetaVec(1:204),4,51);
the2=reshape(thetaVec(205:224),4,5);
the3=reshape(thetaVec(225:229),1,5);

%the1=reshape(thetaVec(1:304),4,76);
%the2=reshape(thetaVec(305:324),4,5);
%the3=reshape(thetaVec(325:329),1,5);






%the1= [ 1/5  1/2 1/4 1/5 1/4; 1/5 1/9 1/4 1/5 1/9];

%the2= [ 1/4  1/5 1/9; 1/4 1/3 1/6 ];

%the3= [ 1/9 1/2 1/9];

bd1=0;
bd2=0;
bd3=0;

Hx_a=zeros(m,1);
Hx_b=zeros(m,1);


%lam =.0001;
lr=.2;
%lam = 0;



jVal_diff=1;

for j=1:5000;


%;d3(6,1);d3(7,1);d3(8,1);d3(9,1);d3(10,1)]

%while jVal_diff>.0000001;

 for i=1:size(X,1);  a2 = [1; sigmoid(the1*X(i,:)')]; a3 = [1; sigmoid(the2*a2)]; hx = sigmoid(the3*a3); d4 = hx-y(i); d3 = the3'*d4.*a3.*(1-a3);  d3 = [d3(2,1); d3(3,1);d3(4,1);d3(5,1)];  d2 = the2'*d3.*a2.*(1-a2); d2 = [d2(2,1); d2(3,1);d2(4,1);d2(5,1)]; bd3 = bd3 + d4*a3'; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end;  


if j>4990;
% calc jVal pre update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_a(k) = sigmoid(the3*A3(:,k)); end;

jVal_a = -(1./m).*sum(y.*(log(Hx_a))+(1-y).*(log(1-Hx_a)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);
end;

% update the
the1 = the1 - (lr/m)*(bd1 + lam*the1); the2 = the2 - (lr/m)*(bd2 + lam*the2);  the3 = the3 - (lr/m)*(bd3 + lam*the3); bd1=zeros(4,51); bd2=zeros(4,5); bd3= zeros(1,5); 


if j>4990;
% calc jVal post update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_b(k) = sigmoid(the3*A3(:,k)); end;

jVal_b = -(1./m).*sum(y.*(log(Hx_b))+(1-y).*(log(1-Hx_b)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);


jVal_diff = jVal_a - jVal_b,
end;

if mod(j,10)==0 && lam<10;  tr=diff_out(the1,the2,the3,X,y); tst=diff_out_2(the1,the2,the3,tmp_X,tmp_y); if tst-tr>.1; lam=lam+.0015; elseif tst-tr<.08 && lam>0; lam=lam-.0015; end ; end;  


end;


