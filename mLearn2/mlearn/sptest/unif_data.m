function [M]=unif_data(X)


m=size(X,1);
M=ones(m,26);


for i=1:m;
  for j=2:26;
    if X(i,j)<-.5 ; M(i,j)=.1;
    elseif X(i,j)>.5 ; M(i,j)=.9;
    elseif X(i,j)>-.5  && X(i,j)<0 ; M(i,j)=.4;
    elseif X(i,j)<.5  && X(i,j)>0 ; M(i,j)=.6;
    elseif X(i,j)==0 ; M(i,j)=0;
    end;
  end;
end;



