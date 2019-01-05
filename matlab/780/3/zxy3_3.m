s=tf('s');
Gpid=0.54*(1+1/(8*s)+0.228*s);
num=10;
den=[1 1 10 1];
G0=tf(num,den);
Gc=G0*Gpid;
G=feedback(Gc,1)
y=step(G)
%-------------------------求超调量
fprintf('稳态响应终值为：');
c=dcgain(G)
fprintf('阶跃响应最大值及对应时间为：');
[Y,t]=max(y)
fprintf('超调量为：');
chaotiao=(Y-c)/c
%---------------------求调节时间
tt=0:0.00001:100;
yy=step(G,tt);
i=length(tt);     
while(yy(i)>0.98*c)&(yy(i)<1.02*c);
i=i-1;     %误差在2%内
end
ts=tt(i)