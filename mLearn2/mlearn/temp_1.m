function [val1, grad] = temp_1(x,theta)

val1 = (theta(1)-5)^2 + (theta(2)-5)^ 2;

grad= zeros(2,1);

grad(1) = 2*(theta(1)-5);
grad(2) = 2*(theta(2)-5);
