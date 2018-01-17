function J = vec_classCost(X, y, theta)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)


m= size(X,1); % num of train ex
predictions = X*theta; % uses Octave vectorized mult to create vector
h  = 1 ./ (1 + e.^-(predictions));


%J = sum(y.*(log(h))+(1-y).*(log(1-h)));

J = -(1/m).*sum(y.*(log(h))+(1-y).*(log(1-h))); 


%examples
%sqrErrors = (g-y).^2; % vector
%J= 1/(2*m)*sum(sqrErrors);
