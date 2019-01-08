s=tf('s');
G=(4*s+1)/(s^2*(s+1)*(2*s+1));
Gc=feedback(G,1);
figure(1)
nyquist(G)
roots(Gc.den{1})
%step(Gc)