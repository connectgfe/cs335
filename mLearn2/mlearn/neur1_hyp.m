function J = neur1_hyp(the1,the2,X)


a2  = [ 1; 1 ./ (1 + e.^-(the1*X'))];


J  = 1 ./ (1 + e.^-(the2*a2));


