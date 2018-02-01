function [jVal, gradient] = o_class_t(theta)

% X is "design matrix" has training ex
% y is class labels
% this fucntion accompanies function h(x)=predictions, a line through data;
% by minimzing J we get the best theta to use in h(x)


X = [ 1 1 1 1; 1 2 2 2; 1 3 3 3; 1 4 4 4];
y = [0;0;1;1];

%X = [ 1 1 ; 1 2 ; 1 3 ; 1 4 ;1 5 ;1 6 ];
%y = [0;0;0;1;1;1];



gradient = zeros(4,1);
%gradient = zeros(2,1);


m= size(X,1); % num of train ex
predictions = X*theta; % uses Octave vectorized mult to create vector
h  = 1 ./ (1 + e.^-(predictions));
x1_val = X*[0;1;0;0];
x2_val = X*[0;0;1;0];
x3_val = X*[0;0;0;1];
%x4_val = X*[0;0;0;0;1];




%x1_val = X*[0;1];



%J = (1/m).*(-y.*(log(h))-(1-y).*(log(1-h)));

jVal = -(1./m).*sum(y.*(log(h))+(1-y).*(log(1-h)));

%J = -(1/(4*m)).*sum((y.*(log(h))+(1-y).*(log(1-h))).*x_val);
gradient(1) = (1./(10*m)).*sum(h-y);

gradient(2) = (1./(10*m)).*sum((h-y).*x1_val);

%gradient(3) = (1/(5*m)).*sum((h-y).*(sqrt(x2_val)));
gradient(3) = (1./(10*m)).*sum((h-y).*x2_val);

gradient(4) = (1./(10*m)).*sum((h-y).*x3_val);

%gradient(5) = (1./(10*m)).*sum((h-y).*x4_val);






%examples
%sqrErrors = (g-y).^2; % vector
%J= 1/(2*m)*sum(sqrErrors);
