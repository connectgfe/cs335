function t = der_tanh(x)

t = 1 - (2./(1+e.^(-2*x)) - 1).^2;
