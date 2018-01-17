function J = classCost(X, y, theta)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)


m= size(X,1); % num of train ex
%predictions = X.*theta; % uses Octave vectorized mult to create vector
J = X.*theta; % uses Octave vectorized mult to create vector



%g  = 1 ./ (1 + e.^-(predictions));


%examples
%sqrErrors = (g-y).^2; % vector
%J= 1/(2*m)*sum(sqrErrors);
