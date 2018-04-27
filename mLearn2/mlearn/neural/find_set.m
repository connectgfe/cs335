function [M]=find_set(X,Y)


m=size(X,1);
n=size(Y,1);


 for i=1:n; 
   for j=1:m;
      if X(j,:)==Y(i,:); M(i)=j; end;
   end;

 end;

