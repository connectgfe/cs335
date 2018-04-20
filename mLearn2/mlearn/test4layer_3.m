function [the1,the2,the3,jVal_diff,lam,lr,out,tmp_tst,tmp_tr,tmp_d_d] = test4layer_3(thetaVec,X,y,lam,lr,tmp_tst,tmp_tr,tmp_d_d)

tmp_X=X;
tmp_y=y;

spl=50;

X([1:spl],:)=[];
y([1:spl],:)=[];


%X([1,2,3,4,5,6,7,8,9,10],:)=[];
%y([1,2,3,4,5,6,7,8,9,10],:)=[];




m=size(X,1);

%the1=reshape(thetaVec(1:684),9,76);
%the2=reshape(thetaVec(685:774),9,10);
%the3=reshape(thetaVec(775:784),1,10);

the1=reshape(thetaVec(1:104),4,26);
the2=reshape(thetaVec(105:124),4,5);
the3=reshape(thetaVec(125:129),1,5);

%the1=reshape(thetaVec(1:204),4,51);
%the2=reshape(thetaVec(205:224),4,5);
%the3=reshape(thetaVec(225:229),1,5);




%the1=reshape(thetaVec(1:304),4,76);
%the2=reshape(thetaVec(305:324),4,5);
%the3=reshape(thetaVec(325:329),1,5);


it_val=10000;


out=zeros(it_val./5,8);
p=1;

%the1= [ 1/5  1/2 1/4 1/5 1/4; 1/5 1/9 1/4 1/5 1/9];

%the2= [ 1/4  1/5 1/9; 1/4 1/3 1/6 ];

%the3= [ 1/9 1/2 1/9];

bd1=0;
bd2=0;
bd3=0;

Hx_a=zeros(m,1);
Hx_b=zeros(m,1);

%tmp_tst=0;
%tmp_tr=0;
%tmp_d_d=0;
%lam =.0001;
%lr=.2;
%lam = 0;



jVal_diff=1;

for j=1:it_val;


%;d3(6,1);d3(7,1);d3(8,1);d3(9,1);d3(10,1)]

%while jVal_diff>.0000001;

 for i=1:size(X,1);  a2 = [1; sigmoid(the1*X(i,:)')]; a3 = [1; sigmoid(the2*a2)]; hx = sigmoid(the3*a3); d4 = hx-y(i); d3 = the3'*d4.*a3.*(1-a3);  d3 = [d3(2,1); d3(3,1);d3(4,1);d3(5,1)];  d2 = the2'*d3.*a2.*(1-a2); d2 = [d2(2,1); d2(3,1);d2(4,1);d2(5,1)]; bd3 = bd3 + d4*a3'; bd2 = bd2 + d3*a2'; bd1 = bd1 + d2*(X(i,:)); end;  


if j>it_val-5;
% calc jVal pre update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_a(k) = sigmoid(the3*A3(:,k)); end;

jVal_a = -(1./m).*sum(y.*(log(Hx_a))+(1-y).*(log(1-Hx_a)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);
end;

% update the
the1 = the1 - (lr/m)*(bd1 + lam*the1); the2 = the2 - (lr/m)*(bd2 + lam*the2);  the3 = the3 - (lr/m)*(bd3 + lam*the3); bd1=zeros(4,26); bd2=zeros(4,5); bd3= zeros(1,5); 


if j>it_val-5;
% calc jVal post update
tmp_thetaVec = [the1(:);the2(:);the3(:)];
for k=1:m; A2(:,k) = [1; sigmoid(the1*X(k,:)')]; A3(:,k) = [1; sigmoid(the2*A2(:,k))];  Hx_b(k) = sigmoid(the3*A3(:,k)); end;

jVal_b = -(1./m).*sum(y.*(log(Hx_b))+(1-y).*(log(1-Hx_b)))+(lam/(2*m)).*sum(tmp_thetaVec.*tmp_thetaVec);


jVal_diff = jVal_a - jVal_b,
end;

if mod(j,5)==0 && lam<2;  

  tr=diff_out(the1,the2,the3,X,y,spl); 
  tst=diff_out_2(the1,the2,the3,tmp_X,tmp_y,spl);  


%  disp('tst'); disp(tst);  disp('tr'); disp(tr); 
 
  d_tst = 1000.*(tmp_tst-tst);
  d_tr  = 1000.*(tmp_tr-tr);
  d_d   = d_tr - d_tst;
  d_dd  = d_d - tmp_d_d;
  out(p,1)=d_tst;
  out(p,2)=d_tr;
  out(p,3)=d_d;  
  out(p,4)=d_dd;

  
%  disp('d_tst'); 
%  disp(d_tst);  
%  disp('d_tr'); disp(d_tr); 

%   if tst-tr>.075; 


   if d_dd>.002; 
%    if d_tr>.1; 
 
     lam=lam+.0015; 
     lr=lr-.01;
   end;

   if lam >0 &&  d_dd<.002 && d_dd > 0; 
%   if lam >0 &&  d_tr<.1 && d_tr > 0; 

      lam = lam -.0015;
      lr=lr+.01; 
   end;

   if lam<0 ; lam =0; end;
   if lr<0 ; lr =.01; end;


%     lr=lr+.0015; 

%       if lr>.01; lr=lr-.005; 
%       end; 
%   elseif tst-tr<.06 && lam>=.015; 
%       lam=lam-.015; 
%       if lr>.01; lr=lr+.00025; 
%       end; 
%   elseif tst-tr>.06 && tst-tr<.1 ; 
%       lr=lr+.005; 
%// from above   end ; 

   out(p,5)=lam;
   out(p,6)=lr;
   out(p,7)=tst;
   out(p,8)=tr;


   p=p+1; 

   tmp_tst=tst; 
   tmp_tr=tr;
   tmp_d_d=d_d;
%  disp('tmp_tst'); disp(tmp_tst);  disp('tmp_tr'); disp(tmp_tr); 
 


%   disp('lam'); disp(lam); disp('lr'); disp(lr); 

end;  


end;


