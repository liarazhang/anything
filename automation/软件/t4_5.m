s=tf('s');
G=400/(s*(s^2+30*s+200));
Gc=feedback(G,1);
roots(Gc.den{1});
figure
step(Gc)
rltool(G)
