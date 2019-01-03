den1=conv(conv([0.125,1],[0.5,1]),[1,1,1]);
g1=tf(1.05,den1);
g2=tf(1.05*[1,1],den1);
step(g1)
hold on
step(g2)
hold on
text(1.2,1.05,'§¶4')
text(3,0.9,'§¶3') 