n = [10; 100; 500; 1000; 5000; 10000];
HugeInteger = [6.08e-9; 3.32e-9; 3.71e-9; 2.90e-9; 2.48e-9; 2.27e-9];
%b1 = mldivide(n,HugeInteger);
BigInteger = [7.59e-9; 5.70e-9; 2.09e-9; 2.14e-9; 2.10e-9; 2.12e-9];
%b2 = mldivide(n,BigInteger);
nAll = 0:1:10500;
HIp = 0.3e-8;
BIp = 0.21e-8;
theoretical = 0.5e-8;
figure(1);
set(gcf,'WindowState','maximized');
xlim([0 10500])
ylim([0 1e-8])
hold on
scatter(n,HugeInteger,'filled','r');
scatter(n,BigInteger,'filled','g');
plot(nAll,HIp*ones(size(nAll)),'r',nAll,BIp*ones(size(nAll)),'g',nAll,theoretical*ones(size(nAll)),'b');
ax = gca;
ax.FontSize = 20;
title("Running time of comparison operation",'FontSize',35);
xlabel("n (number of digits)",'FontSize',30);
ylabel("Running time of operation (s)",'FontSize',30);
legend("HugeInteger (data)","BigInteger (data)","HugeInteger (curve)","BigInteger (curve)","Theoretical (average)",'Location','northeast');
hold off