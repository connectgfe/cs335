function J = batch_test(X)



for i=1:50; e = mod(i,10)+ 5 ; b = e - 4 ; 

temp_X = X(b:e,:), 

end;

