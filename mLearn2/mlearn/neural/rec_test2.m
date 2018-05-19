function R = rec_test2(R,X,r,n)

%R=[R ;0];

display('new');
if r==0 ; return; end;

m=size(R,1);

%while to skip over visited
hlpr=0;
c=1;


while(c<10);

    for i=1:m; 

      if R(i)==X(r,c);   hlpr=1;  %display('in'); 
      end; 
    end;

    if hlpr==0;  
      val=X(r,c);
      display(val);
      display(n);
      display(R(n));


      if R(n)==0;
      R(n)=val;

       end;
      R=rec_test2(R,X,X(r,c),n+1);
    end;

    c++; 

    hlpr=0;     
%    display('c++');
end;

%if k>9 ; return; end;


%val=X(r,k);
%display(val);
%R(n)=val;



%R=rec_test2(R,X,X(r,k),n+1);

%display('yes');

%R=rec_test2(R,X,r,n+1);








