syms f(x)
f(x) = 4+4*x;
fplot(f(x), [0 1000]);
axis([0 1000 0 5000]);
ax = gca;
ax.FontSize = 20; 
title("Memory required for HugeInteger of n digits",'FontSize',35);
xlabel("n (number of digits)",'FontSize',30);
ylabel("memory required (bytes)",'FontSize',30);
