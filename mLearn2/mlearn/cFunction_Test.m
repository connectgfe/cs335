function [jVal, gradient] = cFunction_Test(theta,x)

% ex: if theta [ 1 ; 3 ] val 10, jVal 81 + 49

jVal = (theta(1)-x).^2 + (theta(2)-x).^2;

gradient = zeros(2,1);
gradient(1)=2*(theta(1)-x);
gradient(2)=2*(theta(2)-x);

