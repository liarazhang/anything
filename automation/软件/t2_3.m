k=8;
z=[-1,-2];
p=[0 -5 -6 -3];
[num,den]=zp2tf(z(:),p(:),k);
g=tf(num,den)