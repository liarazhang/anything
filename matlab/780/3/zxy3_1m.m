num=9;
den=[1 1 10 1];
G1=tf(num,den);
G=feedback(G1,1);
step(G)