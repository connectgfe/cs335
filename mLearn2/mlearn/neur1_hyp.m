function J = neur1_hyp(the1,the2,X)




m= size(X,1); % num of train ex
a2  = [ 1; 1 ./ (1 + e.^-(the1*X))];


J  = 1 ./ (1 + e.^-(the2*a2));


