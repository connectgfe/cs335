function J = class_der_t(t0,t1)

%sig=1 ./ (1 + e.^-z);
 

J = (1./4).* ((1 ./ (1 + e.^-(t0+t1)))+ ((1 ./ (1 + e.^-(t0+t1*2)))*2)+ (((1 ./ (1 + e.^-(t0+t1*3)))  -1)*3) + (((1 ./ (1 + e.^-(t0+t1*4)))  -1)*4))
