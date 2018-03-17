function J = neur2_hyp(the1,the2,the3,X)


a2  = [ 1; 1 ./ (1 + e.^-(the1*X'))];

a3  = [ 1; 1 ./ (1 + e.^-(the2*a2))];

J  = 1 ./ (1 + e.^-(the3*a3));


