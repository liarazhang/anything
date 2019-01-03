#include<reg52.h>
#define uchar unsigned char
#define uint unsigned int

#define m0 1//����m1,����m0
#define m1 0
           
#define full_speed_left 40 //������ڸ���״̬��ռ�ձ� ,���ò����飺��30,35,6,25,30,68000,27000,500����
#define full_speed_right 45	//				         				��40,45,6,25,30,68000,27000,500����
#define correct_speed 6 //У��ʱ�ĵ����ֵ�ռ�ձ�
#define turn_speed_left 25
#define turn_speed_right 30	
#define	lenth 68000		//�������ݣ�10000--��100--��500--��2000--80000--76000--68000
#define width 27000		//500--��10-->2000--��60000--30000---��27000
#define check_right 500 //2000--��20--��200--��500
#define midl left1
#define midr right5 

uchar Duty_left,Duty_right,i=0,j=0; //����ռ�ձȱ�־��ȡ1--100 
                
sbit IN1=P1^3;  
sbit IN2=P1^5;  
sbit IN3=P1^2; 
sbit IN4=P1^0;
sbit ENA=P1^4;    
sbit ENB=P1^0;	 

//ѭ���� �������Թܣ����ζ�Ӧ�������ҵ�1,2,3,4,5����
sbit left1 =P3^6; 
sbit left2 =P3^5;
sbit mid3  =P3^4;
sbit right4=P3^3;
sbit right5=P3^2;

void line_left();
void line_right();
void line_straight()reentrant;
//----------------------------------------
void delay(long int Delay_time)//��ʱ����
 {
 uint t=Delay_time;
 while(t--);
 }
//-----------------------------------------
void init()	 //��ʱ����ʼ��
 {
   left1=m0; //��ʼ��
   left2=m0;  //����λ��
   mid3 =m1;   //����λ��
   right4=m0;
   right5=m0;
   TMOD|=0x01;
   TH0=(65536-66)/256;
   TL0=(65536-66)%256;
   EA=1;
   ET0=1;
   TR0=1;
   ENA=1; //ʹ�ܶ˿ڣ���ʼ��
   ENB=1; 
  }
//--------------------------------------------
void time0(void)interrupt 1	 //�жϳ���
{
  i++;						//�������ж���ִ��
  j++;
  if(i<=Duty_left) 
     ENB=1;
  else ENB=0;  
  if(i>100) 
     {ENA=1;i=0;}
  if(j<=Duty_right) 
     ENA=1;
  else ENA=0;
  if(j>100) 
     {ENA=1;j=0;}
TH0=(65536-66)/256;	   //ȡԼ150HZ��12M����ÿ�ζ�ʱ66us,��100�Σ�������ͷ����ı�������ֱ�ӱ�ʾռ�ձȵ���ֵ
TL0=(65536-66)%256;
}
//-----------------------------------------------
void correct_left()//����У������ֵ
 {
   Duty_left =correct_speed;
   Duty_right=full_speed_right;
   IN1=1;
   IN2=0;
   IN3=1;
   IN4=0;
 }
//------------------------------------------------
 void correct_right()//����У������ֵ
 {
   Duty_left =full_speed_left;
   Duty_right=correct_speed;
   IN1=1;
   IN2=0;
   IN3=1;
   IN4=0;
 }
//--------------------------------------------------
void turn_left()//��ת����ֵ
{
  Duty_left =turn_speed_left;
  Duty_right=turn_speed_right;
  IN1=1;	 //ת��ʱһ����ת��һ����ת��
  IN2=0;
  IN3=0;
  IN4=1; 		
}
//---------------------------------------------------
void turn_right()//��ת����ֵ
{
  Duty_left =turn_speed_left;
  Duty_right=turn_speed_right;
  IN1=0;	  //ת��ʱһ����ת��һ����ת��
  IN2=1;	
  IN3=1;	
  IN4=0; 
}
//-----------------------------------------------------
void straight()	//ֱ�ߣ���ֵ
{
  Duty_left =full_speed_left;	//���ҵ��ռ�ձȳ�ʼ��������ֱ���˶��ٶ�
  Duty_right=full_speed_right;	//���������ֵ���ڲ�������ͬ����ռ�ձ�ȡ��ֵͬ������ֵ��Ҫ����д����ȡֵ
  IN1=1;
  IN2=0;
  IN3=1;
  IN4=0; 
}
//-----------------------------------------------------
void line_straight()reentrant //���������reentrant���Եݹ���ã�//һֱ�ߺ�ֱ��ʱ
{
  straight();
  if(right5==m1){line_right();}
  else	
  if(left1==m1){line_left();}
  else
  if(left2==m1)				  //��ֹУ��ʱ��С��������󣬵���2,4�ż������������˼��ܵļ�⣬��������ֱ��ʱ����
    while(left2==m1)
     {correct_left();
       if(right5==m1)
          {
		   line_right();
		   goto label3;
		   }
	   else if(left1==m1)
		 {line_left();
	     goto label3;}
     }
  else 
  if(right4==m1)			   //��ֹУ��ʱ��С��������󣬵���2,4�ż������������˼��ܵļ�⣬��������ֱ��ʱ����
   while(right4==m1)
    {correct_right();
     if(right5==m1)
       { line_right();  goto label3;}
     else if(left1==m1)
		{line_left();goto label3;}
	}
  else
  if((left1==m0)&&(left2==m0)&&(mid3==m0)&&(right4==m0)&&(right5==m0))
    {
	  straight();
	  //delay(lenth);
	  while(right4==m0) //����Ӧ������mid3,����Ϊ����������ȣ�ѡ��right4������ʱ����ȡleft2�Թ�
	    {turn_right();}
	  if(mid3==m1)
	    {line_straight();}
	
	}

	label3: ; //ʲô������
}
//-------------------------------------------------------------------------
void line_right() //�ұ��к���ʱ
{
	straight();//�����ֱ�����ڲ��ܺ���������ֱ��
	delay(lenth);
	if(mid3==m1)
	{
	  turn_right();//ִ������ת�ĸ�ֵ
label:delay(width);	//��widthֵ����ת��ʱmid3�������߿��ʱ����Ҫ��ʱ��
	  if(mid3==m0)
	    while(right4==m0)
	     {}
	  else
	  	  goto label;
		
	 }

	else
	if(mid3==m0)
	   {
	     turn_right();
	     while(right4==m0)
	       {}	
	     if(midr==m1)
	       {line_straight();}
       }		 
}
//-----------------------------------------------------------------
void line_left() //��߳��ֺ���ʱ
{ 
  while(left1==m1)
  {
	if(right5==m1) 
	{
	line_right();
	goto label2;
	} 
   }

   delay(check_right);//�����������ʱ����߳��˺���֮�󣬼�����ʱһ��ʱ�䣬�ж��ұ��Ƿ��������ߣ�
			   //���������ߣ�ִ��line_right()����
	if(right5==m1) 
	{
	line_right();
	goto label2;
	}

   if((mid3==m1)||(left2==m1)||(right4==m1)){line_straight();}
	  else
	  {
	     while(left2==m0)
		    {turn_left();}
	     if(midl==m1)
	        line_straight();    
	  }
label2: ;
}
//--------------------------------------------------------------------
void detect_infrared() //ѭ����������
 { 
   if(right5==m1){line_right();}
   else 
   if(left1==m1){line_left();}
   else
   if(left2==m1){correct_left();}
   else
   if(right4==m1){correct_right();}
   else
   line_straight();
 }
//--------------------------------------
void main(void)//�����򲿷�
{
  init();
  while(1)	//ѭ��������Թܲɼ��ĵ�ƽ�ź�
   {detect_infrared();}
}
