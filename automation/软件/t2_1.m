num1=5*conv(conv([1,2],[1,2]),[1,6,7]);
den1=conv(conv(conv(conv([1,0],[1,1]),[1,1]),[1,1]),[1,0,2,1]);
den2=conv(conv([1,0],[1,1]),[1,4,4]);
g1=tf(num1,den1)
g2=tf(5,den2)