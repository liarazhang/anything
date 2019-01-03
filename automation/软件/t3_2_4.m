num=1.05*[0.4762,1];
den2=conv([1,1,1],[0.5,1]);
den1=conv(den2,[0.125,1]);
g1=tf(num,den1);
g2=tf(num,den2);
step(g1)
hold on
step(g2)
hold on
text(2.6,0.9,'§¶1')
text(0.6,0.6,'§¶5') 