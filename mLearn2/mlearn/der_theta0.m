function J = der_theta0(X, y, theta0, theta1)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)


m= size(X,1); % num of train ex
predictions = X*theta1; % uses Octave vectorized mult to create vector
x_val = X*[0;1];
%examples
sqrErrors = ((theta0 + predictions)-y); % vector
%J= 1/(4*m)*sum((sqrErrors).*x_val);
J= (1/(6*m))*(1/2)*sum(sqrErrors);



