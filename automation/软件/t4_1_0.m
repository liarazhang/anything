k=1;
z=[];
p=[0 -1 -0.2];
[num,den]=zp2tf(z,p,k);
rlocus(num,den),sgrid
[k,r]=rlocfind(num,den)