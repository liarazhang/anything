fp = fopen('E:\����ϵͳ�����\780\1\data.dat','rt');
f=fscanf(fp,'%f',402);
num=fscanf(fp,'%f',4);
den=fscanf(fp,'%f',5);
fclose(fp);
num1=ctranspose(num);
den1=ctranspose(den);
Gs=tf(num1,den1)
bode(Gs)