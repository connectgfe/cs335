function g = class_hyp(X,theta)
%SIGMOID Compute sigmoid function
%   J = SIGMOID(z) computes the sigmoid of z.

% You need to return the following variables correctly 

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the sigmoid of each value of z (z can be a matrix,
%               vector or scalar).

val = sum( X .* theta);



g = 1 ./ (1 + e.^-val);


% =============================================================

end
