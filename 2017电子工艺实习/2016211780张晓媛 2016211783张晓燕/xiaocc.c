#include<reg51.h>
#include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
uchar data v=4;			     //���ת��0~5
uchar data zhuan=0;			 //ת���־
uchar data t=0;				 //��ʱ����	
sbit IN1 =P1^3;
sbit IN2=P1^5;
sbit IN3=P1^2;
sbit IN4=P1^0;
sbit ENA=P1^4;
sbit ENB=P1^1;			 




void Timer1() interrupt 3
{
	TH1=0XFC;	//����ʱ������ֵ����ʱ1ms
	TL1=0X18;
		t++;						 //ÿһ����t2��һ
	if(t==6)t=0;				 //������Ϊһ����Ϊ������������ʱ
	if(P3&0X01)zhuan=2;			 //���̽ͷ̽�⵽����
	if(P3&0X10)zhuan=1;			 //�Ҳ�̽ͷ̽�⵽����
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
TMOD|=0X10;//ѡ��Ϊ��ʱ��1ģʽ��������ʽ1������TR1��������

	TH1=0XFC;	//����ʱ������ֵ����ʱ1ms
	TL1=0X18;	
	ET1=1;//�򿪶�ʱ��1�ж�����
	EA=1;//�����ж�
	TR1=1;//�򿪶�ʱ��			
    while(1)															   
	{	  if(P3==0XE2||P3==0XE3||P3==0XF2||P3==0XFC)you();//��ת
	    else if(P3==0xE6||P3==0xE7)youman();
		else if(P3==0XE8||P3==0XE9||P3==0XF8||P3==0xFC)zuo();//��ת
		else if(P3==0xEC||P3==0xED)zuoman();
		else if(P3==0XF0)zuoyuan();         //����ԭ��ת��
		else if(P3==0XE1)youyuan();         //����ԭ��ת��
		else if(P3==0XFF)stop();        //ֹͣ
		else if(P3==0XE0&&zhuan==1)zuoyuan();//���֮ǰ���̽ͷ��⵽���������ԭ��ת��
		else if(P3==0XE0&&zhuan==2)youyuan();//���֮ǰ�Ҳ�̽ͷ��⵽���������ԭ��ת��
		else qianjin();                     //ǰ��
	}
}
