syms s
g1=1/s+1;
g2=(s+2)/(s^2+2*s+1);
g=factor(((g1+1)*g2)/(1+2*g1+g1*g2))