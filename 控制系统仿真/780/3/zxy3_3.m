s=tf('s');
Gpid=0.54*(1+1/(8*s)+0.228*s);
num=10;
den=[1 1 10 1];
G0=tf(num,den);
Gc=G0*Gpid;
G=feedback(Gc,1)
y=step(G)
%-------------------------�󳬵���
fprintf('��̬��Ӧ��ֵΪ��');
c=dcgain(G)
fprintf('��Ծ��Ӧ���ֵ����Ӧʱ��Ϊ��');
[Y,t]=max(y)
fprintf('������Ϊ��');
chaotiao=(Y-c)/c
%---------------------�����ʱ��
tt=0:0.00001:100;
yy=step(G,tt);
i=length(tt);     
while(yy(i)>0.98*c)&(yy(i)<1.02*c);
i=i-1;     %�����2%��
end
ts=tt(i)