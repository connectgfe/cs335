function [json]= wrap_fmin(X,y)

m = size(X,1);
X([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],:)=[];
y([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],:)=[];

%X([80,81,82,83,84,85,86,87,88,89,90,91,92,93,94],:)=[];
%y([80,81,82,83,84,85,86,87,88,89,90,91,92,93,94],:)=[];






t1= [ 1/2 1/5  1/4  1/3   1/5   1/4 1/9 1/3  1/3  1/6   1/5 1/4  1/6 1/3  1/3  1/3  1/8  1/2 1/2  1/5  1/3 1/5 1/2 1/8 1/9 1/2 1/3 1/3;

 1/9 1/5  1/3  1/3   1/5   1/4 1/9 1/8  1/3  1/6   1/3 1/4  1/6 1/3  1/3  1/3  1/7  1/2 1/4  1/5  1/3 1/5 1/9 1/8 1/9 1/2 1/3 1/3;

1/8 1/5  1/4  1/3   1/5   1/2 1/9 1/9  1/3  1/6   1/5 1/3  1/6 1/3  1/3  1/3  1/8  1/2 1/2  1/8  1/3 1/5 1/2 1/4 1/9 1/2 1/3 1/3;

1/4 1/5  1/4  1/3   1/5   1/7 1/9 1/3  1/4  1/6   1/5 1/4  1/6 1/9  1/3  1/3  1/8  1/2 1/4  1/5  1/3 1/5 1/2 1/8 1/9 1/2 1/3 1/3;
]



t2= [ 1/2 1/4 1/7 1/4 1/9; 1/48 1/8 1/3 1/9 1/7;
      1/4 1/3 1/7 1/3 1/8; 1/2 1/4 1/4 1/7 1/9];
t3= [ 1/4 1/8 1/8 1/4 1/5];

thetaVec= [ t1(:); t2(:); t3(:)];


options = optimset('GradObj', 'on', 'MaxIter', 200);          
[optTheta, functionVal, exitFlag]= fminunc( @(t)(fmin_net_test(t,X,y)),thetaVec,options);



the1=reshape(optTheta(1:112),4,28);
the2=reshape(optTheta(113:132),4,5);
the3=reshape(optTheta(133:137),1,5);

s=struct('M',the1,'N',the2,'O',the3);

json=savejson('s',s);
