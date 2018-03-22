function [the1,the2,the3]= wrap_fmin(thetaVec,X,y)


options = optimset('GradObj', 'on', 'MaxIter', 100);          
[optTheta, functionVal, exitFlag]= fminunc( @(t)(fmin2_net_test(t,X,y)),thetaVec,options);

the1=reshape(optTheta(1:16),2,8);
the2=reshape(optTheta(17:22),2,3);
the3=reshape(optTheta(23:25),1,3);
