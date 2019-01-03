num=1.05*[0.4762 1];
den=conv([0.125 1],conv([0.5 1],[1,1,1]));
g=tf(num,den);
step(g)
hold on