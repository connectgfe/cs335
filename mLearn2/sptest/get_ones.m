function [M]= get_ones(y)

m = size(y,1);
M = zeros(m,1);


%for i=1:m; if y(i)<0;M(i)=0;else M(i)=1; end; end;

for i=1:m; 

 if y(i)>0;
  if y(i)>1; M(i)=.9 ; 
   else M(i)=.7; 
  end; 
 end;  
 if y(i)<0;
  if y(i)<-1; M(i)=.1 ; 
   else M(i)=.3; 
  end; 
 end;  

 end;

