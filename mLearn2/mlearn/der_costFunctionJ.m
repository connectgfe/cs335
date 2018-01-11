function J = der_costFunctionJ(X, y, theta)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)


m= size(X,1); % num of train ex
predictions = X*theta; % uses Octave vectorized mult to create vector
x_val = X*[0;1];
%examples
sqrErrors = (predictions-y); % vector
%J= 1/(4*m)*sum((sqrErrors).*x_val);
J= (1/(2*m))*(1/2)*sum((sqrErrors).*x_val);


