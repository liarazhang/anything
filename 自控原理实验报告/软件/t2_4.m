num0=[2,1];
den0=[1,2,3];
[num,den]=feedback(num0,den0,1,1);
g=tf(num,den)