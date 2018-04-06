function [val]=check_data(M)

m=size(M,1)/7;

for i=0:m; if M(((i+1)*7),1)- M((i*7)+1,1) !=6, val = i; break; end; end;
