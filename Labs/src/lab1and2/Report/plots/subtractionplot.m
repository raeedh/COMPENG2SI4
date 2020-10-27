n = [10; 100; 500; 1000; 5000; 10000];
HugeInteger = [1.35e-7; 2.46e-7; 9.26e-7; 1.95e-6; 9.83e-6; 3.07e-5];
b1 = mldivide(n,HugeInteger);
BigInteger = [2.16e-8; 2.78e-8; 3.47e-8; 6.39e-8; 2.13e-7; 4.59e-7];
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
title("Running time of subtraction operation",'FontSize',35);
xlabel("n (number of digits)",'FontSize',30);
ylabel("Running time of operation (s)",'FontSize',30);
legend("HugeInteger (data)","BigInteger (data)","HugeInteger (curve)","BigInteger (curve)","Theoretical",'Location','northwest');
hold off