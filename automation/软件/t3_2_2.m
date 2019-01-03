num=1.05*[0.4762 1];
den=conv([0.125 1],conv([0.5 1],[1,1,1]));
g=tf(num,den);
g2=tf(1.05,[1,1,1]);
step(g)
hold on
step(g2)
text(2.6,0.9,'§¶1')
text(0.6,0.6,'§¶2') 
hold on