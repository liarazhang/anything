k=1;
z=[];
p=[0 -1];
G=zpk(z,p,k);
rlocus(G);
hold on
k=1;
z=[-2];
p=[0 -1];
G1=zpk(z,p,k);
figure(3);
rlocus(G1);
hold off
figure(2);
sys=feedback(G,1);
step(sys);
hold on
sys1=feedback(G1,1);
step(sys1);
text(5.5,1.1,'G')
text(0.5,0.9,'G1') 
hold off