function [M] = get_data(data)

m=size(data,1);

M = zeros(m/7,1);
k = 0;
i = 1;


for l=i:m/7; k=k+1;
  M(k)=data(i+2,2)-data(i,5); 
  %disp(i);
  i=i+7; 
end;

