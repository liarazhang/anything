% num=30;
% den=conv([1,0],conv([0.1,1],[0.2,1]));
% G0=tf(num,den);
% [Gm,Pm,Wcg,Wcp]=margin(G0);
% w=0:0.1:10000;
% [mag,phase]=bode(G0,w);
% magdb=20*log(mag);
% % L=30/(2*((0.1*2)^2+1)^(1/2)*((0.2*2)^2+1)^(1/2));
% % a=10^(-L/10);
% % T=1/(2*(a)^(1/2));
% % numc=[a*T,1];
% % denc=[T,1];
% 
% phiml=40;
% deta=8;
% phim=phiml-Pm+deta;
% bita=(1-sin(phim*pi/180))/(1+sin(phim*pi/180));
% n=find(magdb+10*log10(1/bita)<=0.0001);
% wc=n(1);
% w1=(wc/10)*sqrt(bita);
% w2=(wc/10)/sqrt(bita);
% numc=[1/w1,1];
% denc=[1/w2,1];
% 
% Gc=tf(numc,denc);
% G=Gc*G0;
% [Gmc,Pmc,Wcgc,Wcpc]=margin(G);
% GmcdB=20*log10(Gmc);
% disp('У��װ�ô��ݺ�����У����ϵͳ�������ݺ���'),Gc,G,
% disp('У����ϵͳ��Ƶ������ָ��'),[GmcdB,Pmc,Wcpc],
% disp('У��װ�õĲ���T��aֵ:'),T=1/w1;
% [T,bita],
% bode(G0,G);
% hold on,margin(G)

num=30;den=conv([1,0],conv([0.1,1],[0.2,1]));
G0=tf(num,den);
[kg,gamma,wg,wc]=margin(G0);
kgdB=20*log10(kg);
w=0.001:0.001:100;
[mag,phase]=bode(G0,w);
disp('δУ��ϵͳ������20lgkg');
[kgdB,wc,gamma],gamma1=40;
delta=6;
phim=gamma1-gamma+delta;
alpha=(1+sin(phim*pi/180))/(1-sin(phim*pi/180));
magdb=20*log10(mag);
n=find(magdb+10*log10(alpha)<=0.0001);
wc=n(1);wcc=wc/1000;
w3=wcc/sqrt(alpha);w4=sqrt(alpha)*wcc;
numc1=[1/w3,1];
denc1=[1/w4,1];
Gc1=tf(numc1,denc1);
w1=wcc/10;w2=w1/alpha;
numc2=[1/w1,1];
denc2=[1/w2,1];
Gc2=tf(numc2,denc2);
Gc=Gc1*Gc2;
G=Gc*G0;
[Gmc,Pmc,Wcgc,Wcpc]=margin(G);
GmcdB=20*log10(Gmc);
disp('��ǰУ�����ֵĴ��ݺ���'),Gc1,
disp('�ͺ�У�����ֵĴ��ݺ���'),Gc2,
disp('������ǰ-�ͺ�У������Ĵ��ݺ���'),Gc,
disp('У����ϵͳ�Ŀ�������'),G,
disp('У����ϵͳ�����ܲ���GmcdB,Wcpc,Pmc���ֶ�ֵ'),[GmcdB,Wcpc,Pmc,alpha],
bode(G0,G)
hold on,margin(G)
