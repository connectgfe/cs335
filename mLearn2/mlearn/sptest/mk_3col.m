function[M]=mk_3col(X)

m=size(X,1);
M=zeros(m,3);



for i=1:m; if X(i,1)>0; M(i,1)=X(i,1); else; M(i,2)=abs(X(i,1)); end; end;

M(:,3)=X(:,2);


