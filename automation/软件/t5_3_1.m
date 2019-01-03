s=tf('s');
G=(s+1)/(s^2*(0.1*s+1));
margin(G)
[Gm1,Pm1,wg1,wc1]=margin(G)