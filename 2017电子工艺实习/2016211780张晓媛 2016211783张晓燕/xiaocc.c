#include<reg51.h>
#include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
uchar data v=4;			     //电机转速0~5
uchar data zhuan=0;			 //转弯标志
uchar data t=0;				 //计时参数	
sbit IN1 =P1^3;
sbit IN2=P1^5;
sbit IN3=P1^2;
sbit IN4=P1^0;
sbit ENA=P1^4;
sbit ENB=P1^1;			 




void Timer1() interrupt 3
{
	TH1=0XFC;	//给定时器赋初值，定时1ms
	TL1=0X18;
		t++;						 //每一毫秒t2加一
	if(t==6)t=0;				 //六毫秒为一周期为电机和数码管延时
	if(P3&0X01)zhuan=2;			 //左侧探头探测到黑线
	if(P3&0X10)zhuan=1;			 //右侧探头探测到黑线
}

void stop()
{
	IN1=0; 
	IN2=0;
	IN3=0;
	IN4=0;
	ENA=0;
	ENB=0;
}		
void qianjin()
{
if(t<=(v+1))
{
	IN1=0;
	IN2=1;
	IN3=1;
	IN4=0;
	ENA=1;
	ENB=1;
	}
	else stop();
}		
void you()
{
if(t<=v)
{
	IN1=0;
	IN2=1;
	IN3=1;
	IN4=0;
	ENA=0;
	ENB=1;
		}
	else stop();
}	

void youman()
{
if(t<=(v-1))
{
	IN1=0;
	IN2=1;
	IN3=1;
	IN4=0;
	ENA=0;
	ENB=1;
		}
	else stop();
}

void zuo()
{
if(t<=v)
{
	IN1=0;
	IN2=1;
	IN3=0;
	IN4=0;
	ENA=1;
	ENB=0;	
	}
	else stop();
}	
void zuoman()
{
if(t<=(v-1))
{
	IN1=0;
	IN2=1;
	IN3=0;
	IN4=0;
	ENA=1;
	ENB=0;	
	}
	else stop();
}
void youyuan()
{	 if(t<=v)
{
	IN1=1;
	IN2=0;
	IN3=1;
	IN4=0;
	ENA=1;
	ENB=1; 	}
	else stop();
}	
void zuoyuan()
{	  if(t<=v)	{
	IN1=0;
	IN2=1;
	IN3=0;
	IN4=1;
	ENA=1;
	ENB=1;	}
	else stop();
}	

void main()
{
TMOD|=0X10;//选择为定时器1模式，工作方式1，仅用TR1打开启动。

	TH1=0XFC;	//给定时器赋初值，定时1ms
	TL1=0X18;	
	ET1=1;//打开定时器1中断允许
	EA=1;//打开总中断
	TR1=1;//打开定时器			
    while(1)															   
	{	  if(P3==0XE2||P3==0XE3||P3==0XF2||P3==0XFC)you();//右转
	    else if(P3==0xE6||P3==0xE7)youman();
		else if(P3==0XE8||P3==0XE9||P3==0XF8||P3==0xFC)zuo();//左转
		else if(P3==0xEC||P3==0xED)zuoman();
		else if(P3==0XF0)zuoyuan();         //向左原地转弯
		else if(P3==0XE1)youyuan();         //向右原地转弯
		else if(P3==0XFF)stop();        //停止
		else if(P3==0XE0&&zhuan==1)zuoyuan();//如果之前左侧探头检测到轨道则向左原地转弯
		else if(P3==0XE0&&zhuan==2)youyuan();//如果之前右侧探头检测到轨道则向右原地转弯
		else qianjin();                     //前进
	}
}
