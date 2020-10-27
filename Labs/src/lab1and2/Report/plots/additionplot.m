n = [10; 100; 500; 1000; 5000; 10000];
HugeInteger = [1.23e-7; 2.30e-7; 1.00e-6; 2.11e-6; 9.46e-6; 3.00e-5];
b1 = mldivide(n,HugeInteger);
BigInteger = [1.69e-8; 3.24e-8; 4.38e-8; 5.88e-8; 2.08e-7; 4.52e-7];
b2 = mldivide(n,BigInteger);
nAll = 0:1:10500;
syms theoretical(x)
theoretical(x) = x*1e-9;
theoretical(nAll);
figure(1);
set(gcf,'WindowState','maximized');
xlim([0 10500])
ylim([0 3.50e-5])
hold on
scatter(n,HugeInteger,'filled','r');
scatter(n,BigInteger,'filled','g');
plot(nAll,nAll*b1,'r',nAll,nAll*b2,'g',nAll,theoretical(nAll),'b');
ax = gca;
ax.FontSize = 20;
title("Running time of addition operation",'FontSize',35);
xlabel("n (number of digits)",'FontSize',30);
ylabel("Running time of operation (s)",'FontSize',30);
legend("HugeInteger (data)","BigInteger (data)","HugeInteger (curve)","BigInteger (curve)","Theoretical",'Location','northwest');
hold off