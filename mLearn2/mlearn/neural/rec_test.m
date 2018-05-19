function R = rec_test(R,X,r,c,n)


display('new');
if r==0 || c==0; return; end;

m=size(R,1);

%while to skip over visited
hlpr=0;
k=c;

while(k<7);
    for i=1:m; 
      if R(i)==X(r,k);  hlpr=1;  end; 
    end;

    if hlpr==0;  break; end;    

    k++; 
   % c++;
    hlpr=0;     
    display('c++');
end;

if k>6 ; return; end;


val=X(r,k);
display(val);
R(n)=val;



R=rec_test(R,X,X(r,k),c,n+1);

display('yes');

R=rec_test(R,X,r,c+1,n+1);








