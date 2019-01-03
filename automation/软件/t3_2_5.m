den1=conv([1,1,1],[0.5,1]);
g1=tf(1.05*[0.4762,1],den1);
g2=tf(1.05,[1,1,1]);
step(g1)
hold on
step(g2)
hold on