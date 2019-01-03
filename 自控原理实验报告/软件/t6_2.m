num=30 ; 
den= conv ([1, 0], [0.1, 1]) ;
den= conv (den, [0.2, 1]) ;
GO= tf (num, den) ; 
margin (GO) 
gamma0= 40 ; delta= 6 ;
ganna= gamma0 + delta ;
w= 0.01 : 0.01 : 1000;
[mag, phase]= bode (GO, w) ;
n= find (180 + phase - ganna<=0.1);
wgamma= n(1)/100 
[mag, phase] = bode (GO , wgamma) ;
Lhc = -20*log10(mag) ;
beta= 10^(Lhc/20) ;
w2 = wgamma/ 10 ;
w1 = beta*w2 ;
numc = [1/w2, 1];
denc= [1/w1, 1] ; 
Gc= tf (numc, denc); 
Gc
G=GO*Gc;
bode (GO, G) , hold on, margin (G) , beta 
G