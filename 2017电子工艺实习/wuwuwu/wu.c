#include<reg52.h>
#define uchar unsigned char
#define uint unsigned int

#define m0 1//黑线m1,白线m0
#define m1 0
           
#define full_speed_left 40 //方便调节各个状态的占空比 ,可用参数组：（30,35,6,25,30,68000,27000,500）；
#define full_speed_right 45	//				         				（40,45,6,25,30,68000,27000,500）；
#define correct_speed 6 //校正时的低速轮的占空比
#define turn_speed_left 25
#define turn_speed_right 30	
#define	lenth 68000		//测试数据：10000--》100--》500--》2000--80000--76000--68000
#define width 27000		//500--》10-->2000--》60000--30000---》27000
#define check_right 500 //2000--》20--》200--》500
#define midl left1
#define midr right5 

uchar Duty_left,Duty_right,i=0,j=0; //左右占空比标志，取1--100 
                
sbit IN1=P1^3;  
sbit IN2=P1^5;  
sbit IN3=P1^2; 
sbit IN4=P1^0;
sbit ENA=P1^4;    
sbit ENB=P1^0;	 

//循迹口 五组红外对管，依次对应从左往右第1,2,3,4,5五组
sbit left1 =P3^6; 
sbit left2 =P3^5;
sbit mid3  =P3^4;
sbit right4=P3^3;
sbit right5=P3^2;

void line_left();
void line_right();
void line_straight()reentrant;
//----------------------------------------
void delay(long int Delay_time)//延时函数
 {
 uint t=Delay_time;
 while(t--);
 }
//-----------------------------------------
void init()	 //定时器初始化
 {
   left1=m0; //初始化
   left2=m0;  //白线位置
   mid3 =m1;   //黑线位置
   right4=m0;
   right5=m0;
   TMOD|=0x01;
   TH0=(65536-66)/256;
   TL0=(65536-66)%256;
   EA=1;
   ET0=1;
   TR0=1;
   ENA=1; //使能端口，初始化
   ENB=1; 
  }
//--------------------------------------------
void time0(void)interrupt 1	 //中断程序
{
  i++;						//调速在中断中执行
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
TH0=(65536-66)/256;	   //取约150HZ，12M晶振，每次定时66us,分100次，这样开头定义的变量正好直接表示占空比的数值
TL0=(65536-66)%256;
}
//-----------------------------------------------
void correct_left()//向左校正，赋值
 {
   Duty_left =correct_speed;
   Duty_right=full_speed_right;
   IN1=1;
   IN2=0;
   IN3=1;
   IN4=0;
 }
//------------------------------------------------
 void correct_right()//向右校正，赋值
 {
   Duty_left =full_speed_left;
   Duty_right=correct_speed;
   IN1=1;
   IN2=0;
   IN3=1;
   IN4=0;
 }
//--------------------------------------------------
void turn_left()//左转，赋值
{
  Duty_left =turn_speed_left;
  Duty_right=turn_speed_right;
  IN1=1;	 //转弯时一个正转，一个反转，
  IN2=0;
  IN3=0;
  IN4=1; 		
}
//---------------------------------------------------
void turn_right()//右转，赋值
{
  Duty_left =turn_speed_left;
  Duty_right=turn_speed_right;
  IN1=0;	  //转弯时一个正转，一个反转，
  IN2=1;	
  IN3=1;	
  IN4=0; 
}
//-----------------------------------------------------
void straight()	//直走，赋值
{
  Duty_left =full_speed_left;	//左右电机占空比初始化，调节直线运动速度
  Duty_right=full_speed_right;	//鉴于左右轮电机内部阻力不同，故占空比取不同值，这组值需要单独写程序取值
  IN1=1;
  IN2=0;
  IN3=1;
  IN4=0; 
}
//-----------------------------------------------------
void line_straight()reentrant //函数名后加reentrant可以递归调用，//一直走黑直线时
{
  straight();
  if(right5==m1){line_right();}
  else	
  if(left1==m1){line_left();}
  else
  if(left2==m1)				  //防止校正时，小车冲出过大，导致2,4号检测管屏蔽了两端检测管的检测，避免其走直线时出轨
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
  if(right4==m1)			   //防止校正时，小车冲出过大，导致2,4号检测管屏蔽了两端检测管的检测，避免其走直线时出轨
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
	  while(right4==m0) //本来应该是用mid3,但是为了提高灵敏度，选择right4；向左时，可取left2对管
	    {turn_right();}
	  if(mid3==m1)
	    {line_straight();}
	
	}

	label3: ; //什么都不做
}
//-------------------------------------------------------------------------
void line_right() //右边有黑线时
{
	straight();//这里的直走是在不管红外检测结果的直行
	delay(lenth);
	if(mid3==m1)
	{
	  turn_right();//执行向右转的赋值
label:delay(width);	//由width值决定转弯时mid3经过黑线宽度时所需要的时间
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
void line_left() //左边出现黑线时
{ 
  while(left1==m1)
  {
	if(right5==m1) 
	{
	line_right();
	goto label2;
	} 
   }

   delay(check_right);//左边遇到黑线时，左边出了黑线之后，继续延时一段时间，判断右边是否遇到黑线，
			   //若遇到黑线，执行line_right()函数
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
void detect_infrared() //循迹，红外检测
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
void main(void)//主程序部分
{
  init();
  while(1)	//循环检测红外对管采集的电平信号
   {detect_infrared();}
}
