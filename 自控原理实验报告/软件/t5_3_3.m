num=[1 1];
den=[0.1 1 0 0];
[n,p,v]=bode(num,den);
vi=3.16;
ni=spline(v,n,vi);
k=1/ni
num2=k;
margin(num2,den)