#include<reg51.h>
#include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
#define t 1
uchar code seg_data[ ] = {0xc0,0xf9,0xa4,0xb0,0x99,0x92,0x82,0xf8,0x80,0x90,0xff};//0~9的段码表,0x00为熄灭符
uchar data disp_buf[7] = {0x00,0x00,0x00,0x00,0x00,0x00,0x00};//显示缓冲区

sbit IN1 =P1^3;
sbit IN2=P1^5;
sbit IN3=P1^2;
sbit IN4=P1^0;
sbit LED1=P2^6;
sbit LED2=P2^7;	
sbit S1=P1^6;
unsigned int count=0;					  
 
/********以下是延时函数********/
void Delay_ms(uint xms)      	//延时程序，xms是形式参数
{  																										            
	uint i, j;
	for(i=xms;i>0;i--)          	 // i=xms,即延时xms, xms由实际参数传入一个值
		for(j=115;j>0;j--);		     //此处分号不可少
}
/********以下是显示函数********/

display()
{
   P0=seg_data[0];  				//显示毫秒十位
   P2=0xfe;				            //开个位显示(开第1只数码管)
   Delay_ms(t);						//延时10ms
   P0=seg_data[1];  				//显示毫秒百位
   P2=0xfd;							//开十位显示(开第2只数码管)
   Delay_ms(t);						//延时10ms
   P0=seg_data[2];  				//显示秒个位
   P2=0xfb;				            //开百位显示(开第3只数码管)
   Delay_ms(t);						//延时10ms
   P0=seg_data[3];  				//显示秒十位
   P2=0xf7;							//开个位显示(开第4只数码管)
   Delay_ms(t);						//延时10ms
   P0=seg_data[4];  				//显示分个位
   P2=0xef;				            //开十位显示(开第5只数码管)
   Delay_ms(t);						//延时10ms
   P0=seg_data[5];  				//显示分十位
   P2=0xdf;							//开个位显示(开第6只数码管)
   Delay_ms(t);						//延时10ms
   P2=0xff;
}

stop()
{
	IN1=0; 
	IN2=0;
	IN3=0;
	IN4=0;
//	Delay_ms(1000);
}
qianjin()
{
	IN1=1;
	IN2=0;
	IN3=0;
	IN4=1;
}		
houtui()
{
    IN1=0; 
	IN2=1;
	IN3=1;
	IN4=0;
}	
     
//****************主程序******************//
void main()
{  P0=0xff;
   P2=0xff;
   P1=0xff;
 //  TMOD=0x01; 			    //定时器T0方式1
 //  TH0=0xfe; TL0=0x0c;      //1ms定时初值
 //  EA=1; ET0=1; TR0=1;		//开总中断,开定时器T0中断,启动定时器T0
   count = 0;
   while(1)
   {
       LED1=0;
       LED2=0;
       display();
    	count++;
    	if( count<100  )
       {
    	    houtui();
       }
    	else 
    	{
	      if(count<200)
       {
	       stop();
	   }
	   else
       {
	   	   if ( count < 300 )
		   {
              qianjin();
		   }
		   else 
		   {
    	   	   if ( count < 400 )
	    	   {
                 stop();
		       }
			   else
			   {
			      count = 0 ;
			   }
		   }
        }
    }
	}
}