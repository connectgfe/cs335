function [R] = ismem(X)

m=size(X,1);

M=zeros(m,15);
%R=zeros(m,14);

for k=1:m;

 for i=1:m; M(i,[1:14]) = X(k,:)==X(i,:); M(i,15)=sum(M(i,[1:14])); end;

   n=1; 
   for j=1:m; if M(j,15)>11; R(k,n)=j; n=n+1; end;  end;

 M=zeros(m,15);

end;

