G=tf(10,[1,2,10]);
G1=tf([2,10],[1,2,10]);
G2=tf([1,0.5,10],[1,2,10]);
G3=tf([1,0.5,0],[1,2,10]);
G4=tf(1,[1,2,10]);
step(G)
hold on
step(G1)
hold on
text(1.5,1.2,'G')
text(1.1,1.45,'G1')
grid on