for n=1:201
    if n <10
        f2(n)=2*f1(n);
    elseif (n<=100)&(abs(f1(n))<15)
        f2(n)=f1(n)^2;
    else
        f2(n)=f1(n-3);
    end
end
plot(t,f2)
title('f2-t����ͼ');
xlabel('t');
ylabel('f2(t)');
fp=fopen('E:\����ϵͳ�����\780\1\result.mat','wt');
fprintf(fp,'%4d',f2);
fclose(fp)