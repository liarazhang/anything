t = 0:1:200;  
tp=random('poisson',0:200,1,201);
num=[1 3 4 5];
den=[2 3 5 3 6];
fp = fopen('E:\控制系统与仿真\780\1\data.dat','wt');
fprintf(fp, '%4d', t);
fprintf(fp,'\n');
fprintf(fp, '%4d', tp);
fprintf(fp,'\n');
fprintf(fp,'%4d',num);
fprintf(fp,'\n');
fprintf(fp,'%4d',den);
fclose(fp)