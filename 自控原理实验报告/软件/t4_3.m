s=tf('s');
G=10/(0.5*s^2+s);
Gc=feedback(G,1);
roots(Gc.den{1});
figure
step(Gc)
rltool(Gc)