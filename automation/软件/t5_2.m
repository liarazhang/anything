s=tf('s');
G=31.6/(s*(0.01*s+1)*(0.1*s+1));
margin(G)
[Gm1,Pm1,wg1,wc1]=margin(G)
%Gc=feedback(G,1);
%step(Gc)