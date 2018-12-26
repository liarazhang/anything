datas segment
    hour db 0
    minute db 0
    second db 0  
    year dw 0
    month db 0
    day db 0
    chour db 0
    cminute db 0
    csecond db 1
    flagst db 0
    date db "date:0000-00-00$"
    time1 db "time:00:00:00$"  
    time2 db "count:00:00:01$"
    len0 equ $-date
    len1 equ $-time1 
    len2 equ $-time2
    num1 db 10 
    num2 db 100  
    string1 db "press 'c' start count$" 
    string2 db "press 'e' exit$" 
    string3 db "LiaraZhang$" 
    string4 db "2016211780$"
    lens1 db $-string1
    lens2 db $-string2 
    lens3 db $-string3  
    hang1 db 0                          
    hang2 db 5 
    hang3 db 8
    hang4 db 3
    hang5 db 1 
    hang6 db 6
    hang7 db 2
    hang8 db 7
    hang9 db 4 
    xx db 04h, '$'    
datas ends
stacks segment
    dw 128 dup(8)
stacks ends
codes segment 
    assume cs:codes,ds:datas
start:
    mov ax,datas
    mov ds,ax
    mov es,ax  
    ;--------------------
    mov ax,0600h
    mov bx,0700h
    mov cx,0000h
    mov dx,194fh
    int 10h
    call show_string1 
    call show_string2 
    call show_string3 
    call show_string4
update_date:
    call get_date
    call show_date 
begin:
 mov ah,01h
    int 16h
    jnz jpre
    jmp beg
jpre:
    call judge_press  
beg:
    call show_time 
    call show_count  
    cmp flagst,1
    je jishu  
    jmp bujishu
jishu:
    mov ah,86h
    mov cx,0x0f
    mov dx,0x4240     
    int 15h 
    call printxx1
    call printxx2 
    call printxx3
    call printxx4
    call printxx5 
    call printxx6
    call printxx7
    call printxx8 
    call printxx9  
    call count
bujishu:
    cmp hour,17h
    jae com1    
    jmp begin 
com1:
    cmp minute,3bh
    jae com2 
    jmp begin
com2:
    cmp second,3ah
    jae update_date 
    jmp begin
;---------------------------------show time
show_time proc 
    mov ah,2ch ; cx:dx=hour min:sec
    int 21h  
bg3:
    cmp second,dh
    jne upsec 
bg2:
    cmp minute,cl 
    jne upmin 
bg1:
    cmp hour,ch
    jne uphour 
    jmp show
uphour:
    mov hour,ch
    xor ax,ax
    mov al,hour ;hour
    div num1
    add al,30h
    add ah,30h
    mov time1[5],al
    mov time1[6],ah
    jmp bg2
upmin: 
    mov minute,cl
    xor ax,ax
    mov al,minute ;minute
    div num1
    add al,30h
    add ah,30h
    mov time1[8],al
    mov time1[9],ah
    jmp bg3
upsec: 
    mov second,dh    
    xor ax,ax
    mov al,second ;second
    div num1
    add al,30h
    add ah,30h
    mov time1[11],al
    mov time1[12],ah
    jmp bg2
show:
    mov ax,0200h
    mov bx,0000h
    mov dh,8 ;hang
    mov dl,10 ;lie
    int 10h
    lea dx,time1
    mov ah,09h
    int 21h 
    ret
show_time endp 
;------------------------------get system date 
get_date proc
    mov ah,2ah
    int 21h
    mov year,cx
    mov month,dh
    mov day,dl 
    ret
get_date endp
;------------------------------show date    
show_date proc
    mov ax,year ;year
    div num2   
    mov bx,ax 
    xor ax,ax
    mov al,bl
    div num1
    add al,30h
    add ah,30h
    mov date[5],al
    mov date[6],ah 
    xor ax,ax
    mov al,bh 
    div num1
    add al,30h
    add ah,30h
    mov date[7],al
    mov date[8],ah 
    xor ax,ax
    mov al,month ;month
    div num1
    add al,30h
    add ah,30h
    mov date[10],al
    mov date[11],ah      
    xor ax,ax
    mov al,day ;day
    div num1
    add al,30h
    add ah,30h
    mov date[13],al
    mov date[14],ah
    ;show
    mov ax,0200h
    mov bx,0000h
    mov dh,7 ;hang
    mov dl,10 ;lie
    int 10h
    lea dx,date
    mov ah,09h
    int 21h
    ret
show_date endp 
;------------------------------show strings  
show_string4 proc 
    mov ax,0200h
    mov bx,0000h
    mov dh,15;hang
    mov dl,55 ;lie
    int 10h
    lea dx,string4
    mov ah,09h
    int 21h
    ret
show_string4 endp 
show_string3 proc 
    mov ax,0200h
    mov bx,0000h
    mov dh,14;hang
    mov dl,55 ;lie
    int 10h
    lea dx,string3
    mov ah,09h
    int 21h
    ret
show_string3 endp 
show_string2 proc 
    mov ax,0200h
    mov bx,0000h
    mov dh,5;hang
    mov dl,10 ;lie
    int 10h
    lea dx,string2
    mov ah,09h
    int 21h
    ret
show_string2 endp 
show_string1 proc
    mov ax,0200h
    mov bx,0000h 
    mov dh,4 ;hang
    mov dl,10 ;lie
    int 10h
    lea dx,string1
    mov ah,09h
    int 21h  
    ret
show_string1 endp 
;------------------------------judge press
judge_press proc near
    mov ah,00h
    int 16h
comc:
    cmp al,63h ;press c
    je jcount
    jmp come
jcount:
    mov flagst,1
    call count
    ret
come:
    cmp al,65h ;press e
    je jexit
jexit:
    call exit      
    ret
judge_press endp
;------------------------------show count
show_count proc 
    mov ax,0200h
    mov bx,0000h 
    mov dh,10 ;hang
    mov dl,10 ;lie
    int 10h
    lea dx,time2
    mov ah,09h
    int 21h  
    ret
show_count endp
;------------------------------count
count proc
    xor ax,ax
    mov al,csecond
    inc al
    cmp al,3bh
    ja jinwei1
    mov csecond,al
    div num1
    add al,30h
    add ah,30h
    mov time2[12],al
    mov time2[13],ah
    ret
jinwei1:
    mov time2[12],30h
    mov time2[13],30h
    mov csecond,0
    xor ax,ax
    mov al,cminute
    inc al
    cmp al,3bh
    ja jinwei2
    mov cminute,al
    div num1
    add al,30h
    add ah,30h
    mov time2[9],al
    mov time2[10],ah
    ret
jinwei2:
    mov time2[9],30h
    mov time2[10],30h
    mov cminute,0
    xor ax,ax
    mov al,chour
    inc al
    mov chour,al
    div num1
    add al,30h
    add ah,30h
    mov time2[6],al
    mov time2[7],ah
    ret
count endp
;----------------------------------show stars  
printxx1 proc              
    mov ax, 0600h          
    mov bx, 0900h
    mov cx, 002ch
    mov dx, 092ch
    int 10h
    mov ax, 0200h          
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang1
    mov dl, 2ch
    int 10h
    inc hang1              
    mov dx, offset xx      
    mov ah, 09h
    int 21h
    cmp hang1, 0ah         
    je chongzhi1
    jmp jieshu1
chongzhi1:                 
    mov hang1, 0
jieshu1:
    ret
printxx1 endp     
        
printxx2 proc              
    mov ax, 0600h         
    mov bx, 0900h
    mov cx, 0030h
    mov dx, 0930h
    int 10h   
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang2
    mov dl, 30h
    int 10h
    inc hang2
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang2, 0ah
    je chongzhi2
    jmp jieshu2
chongzhi2:
    mov hang2, 0
jieshu2:
    ret
printxx2 endp 
    
printxx3 proc             
    mov ax, 0600h          
    mov bx, 0900h
    mov cx, 0034h
    mov dx, 0934h
    int 10h
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang3
    mov dl, 34h
    int 10h    
    inc hang3
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang3, 0ah
    je chongzhi3
    jmp jieshu3
chongzhi3:
    mov hang3, 0
jieshu3:
    ret
printxx3 endp 
    
printxx4 proc              
    mov ax, 0600h         
    mov bx, 0900h
    mov cx, 0038h
    mov dx, 0938h
    int 10h    
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang4
    mov dl, 38h
    int 10h   
    inc hang4
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang4, 0ah
    je chongzhi4
    jmp jieshu4
chongzhi4:
    mov hang4, 0
jieshu4:
    ret
printxx4 endp 
    
printxx5 proc              
    mov ax, 0600h          
    mov bx, 0900h
    mov cx, 003ch
    mov dx, 093ch
    int 10h   
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang5
    mov dl, 3ch
    int 10h   
    inc hang5
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang5, 0ah
    je chongzhi5
    jmp jieshu5
chongzhi5:
    mov hang5, 0
jieshu5:
    ret
printxx5 endp     

printxx6 proc              
    mov ax, 0600h          
    mov bx, 0900h
    mov cx, 0040h
    mov dx, 0940h
    int 10h    
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang6
    mov dl, 40h
    int 10h    
    inc hang6
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang6, 0ah
    je chongzhi6
    jmp jieshu6
chongzhi6:
    mov hang6, 0
jieshu6:
    ret
printxx6 endp  
    
printxx7 proc              
    mov ax, 0600h        
    mov bx, 0900h
    mov cx, 0044h
    mov dx, 0944h
    int 10h   
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang7
    mov dl, 44h
    int 10h   
    inc hang7
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang7, 0ah
    je chongzhi7
    jmp jieshu7
chongzhi7:
    mov hang7, 0
jieshu7:
    ret
printxx7 endp
    
printxx8 proc              
    mov ax, 0600h         
    mov bx, 0900h
    mov cx, 0048h
    mov dx, 0948h
    int 10h    
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang8
    mov dl, 48h
    int 10h
    inc hang8
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang8, 0ah
    je chongzhi8
    jmp jieshu8
chongzhi8:
    mov hang8, 0
jieshu8:
    ret
printxx8 endp
    
printxx9 proc              
    mov ax, 0600h          
    mov bx, 0900h
    mov cx, 004ch
    mov dx, 094ch
    int 10h     
    mov ax, 0200h
    mov bx, 0000h
    mov cx, 0000h
    mov dh, hang9
    mov dl, 4ch
    int 10h
    inc hang9
    mov dx, offset xx
    mov ah, 09h
    int 21h
    cmp hang9, 0ah
    je chongzhi9
    jmp jieshu9
chongzhi9:
    mov hang9, 0
jieshu9:
    ret
printxx9 endp              
;----------------------------exit
exit proc
    mov ax,0600h
    mov bx,0700h
    mov cx,0000h
    mov dx,194fh
    int 10h
    mov ah,4ch
    int 21h
exit endp    
ends
end start