G=tf(10,[1,2,10]);
G1=tf([2,10],[1,2,10]);
G2=tf([1,0.5,10],[1,2,10]);
G3=tf([1,0.5,0],[1,2,10]);
G4=tf(1,[1,2,10]);
step(G)
hold on
step(G3)
hold on 
text(0.5,1.2,'G')
text(0.6,0,'G3') 
grid on