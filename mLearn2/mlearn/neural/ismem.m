function [R] = ismem(X,f)

m=size(X,1);

% f is num features

M=zeros(m,f+1);

for k=1:m;

 % makes matrix of 1(same) 0(not same) compare k to all, col f+1 is sum
 for i=1:m; M(i,[1:f]) = X(k,:)==X(i,:); M(i,f+1)=sum(M(i,[1:f])); end;

   % if col f+1 > val, add k's relatives to R
   n=1; 
   for j=1:m; if M(j,f+1)>11; R(k,n)=j; n=n+1; end;  end;

 M=zeros(m,f+1);

end;

