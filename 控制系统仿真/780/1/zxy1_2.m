fp = fopen('E:\����ϵͳ�����\780\1\data.dat','rt');
t=fscanf(fp,'%d',201);
f1=fscanf(fp,'%f',201);
fclose(fp);
plot(t,f1);
title('f1-t����ͼ');
xlabel('t');ylabel('f1');
