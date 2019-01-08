s=tf('s');
Gc=(10/s)/(0.1*s+1)*6*(1.2*s+1)*(0.15*s+1)/(6*s+1)/(0.05*s+1)/(0.01*s+1)
G=feedback(Gc,1)
bode(Gc)
margin(Gc)