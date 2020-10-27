n = [10; 100; 500; 1000; 5000; 10000];
HugeInteger = [1.80e-7; 7.08e-6; 1.52e-4; 6.22e-4];
p1 = polyfit(n(1:4),HugeInteger,2);
BigInteger = [3.23e-8; 5.69e-8; 1.06e-7; 3.56e-7; 7.85e-6; 3.05e-5];
p2 = polyfit(n,BigInteger,2);
nAll = 0:1:10500;
syms theoretical(x)
theoretical(x) = (x^2)*1e-11;
theoretical(nAll);
figure(1);
set(gcf,'WindowState','maximized');
xlim([0 10500])
ylim([0 1e-3])
hold on
scatter(n(1:4),HugeInteger,'filled','r');
scatter(n,BigInteger,'filled','g');
plot(nAll,p1(1)*nAll.^2+p1(2)*nAll+p1(3),'r',nAll,p2(1)*nAll.^2+p2(2)*nAll+p2(3),'g',nAll,theoretical(nAll),'b');
ax = gca;
ax.FontSize = 20;
title("Running time of multiplication operation",'FontSize',35);
xlabel("n (number of digits)",'FontSize',30);
ylabel("Running time of operation (s)",'FontSize',30);
legend("HugeInteger (data)","BigInteger (data)","HugeInteger (curve)","BigInteger (curve)","Theoretical",'Location','northeast');
hold off