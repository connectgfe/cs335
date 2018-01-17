function [jVal, gradient] = class_t(X, y, theta)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)




m= size(X,1); % num of train ex
predictions = X*theta; % uses Octave vectorized mult to create vector
h  = 1 ./ (1 + e.^-(predictions));
x_val = X*[0;1];
%J = (1/m).*(-y.*(log(h))-(1-y).*(log(1-h)));

jVal = -(1/m).*sum(y.*(log(h))+(1-y).*(log(1-h)));
gradient = zeros(2,1);

%J = -(1/(4*m)).*sum((y.*(log(h))+(1-y).*(log(1-h))).*x_val);
gradient(1) = -(1/(5*m)).*sum(h-y);

gradient(2) = -(1/(5*m)).*sum((h-y).*x_val);





%examples
%sqrErrors = (g-y).^2; % vector
%J= 1/(2*m)*sum(sqrErrors);
