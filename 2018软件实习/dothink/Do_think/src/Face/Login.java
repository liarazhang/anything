package Face;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	JPanel pan1,pan2,pan3,pan4,pan5 = null;
	JLabel title,name,password = null;
	JTextField name_in = null;
	JPasswordField password_in = null;
	JRadioButton rb1,rb2 = null;
	JButton b1,b2 = null;

	String sql1 = "jdbc:odbc:Database";
	String sql2 = "select * from 管理人员注册表";
	String sql3 = "select * from 销售人员注册表";
	
    public static void main(String[] args) {  
    	
    	Login mUI = new Login();  
    }  

    public Login() {  
        pan1 = new JPanel();  
        title = new JLabel("欢迎登陆本系统");
		title.setFont(new Font("宋体",Font.BOLD, 20));
		pan1.add(title);
		
        pan2 = new JPanel();
        name = new JLabel("用户名：");
        name_in = new JTextField(15);
        pan2.add(name);
        pan2.add(name_in);
        
        pan3 = new JPanel();     
        password = new JLabel("密    码："); 
        password_in = new JPasswordField(15);
		password_in.setEchoChar('*');
		pan3.add(password);
		pan3.add(password_in);
 
        pan4 = new JPanel();
        rb1 = new JRadioButton("销售人员");  
        rb2 = new JRadioButton("管理人员"); 
        ButtonGroup bg = new ButtonGroup();  
        bg.add(rb1);  
        bg.add(rb2);
        pan4.add(rb1);
        pan4.add(rb2);
        
        pan5 = new JPanel();
        b1 = new JButton("登录");  
        b2 = new JButton("重置"); 
        pan5.add(b1);
        pan5.add(b2);
        b1.addActionListener(this);  
        b2.addActionListener(this);  
         
        this.add(pan1);  
        this.add(pan2);  
        this.add(pan3);  
        this.add(pan4);  
        this.add(pan5);

        this.setLayout(new GridLayout(5,1));   
        this.setTitle("登陆Dothink销售管理系统");          
        this.setSize(400,300);         
        this.setLocation(400, 200);           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  
        this.setResizable(false);  
    }  

    //重置
    public void clear(){  
    	name_in.setText("");  
    	password_in.setText(""); 
    }
    
    //button事件判断
    public void actionPerformed(ActionEvent e) {
//    	loop:
    		if(e.getActionCommand() == "登录"){
//    		if(rb1.isSelected()){  
//    			Access access = new Access();
//    			access.init(sql1);	//初始化（驱动、连接）
//    			try{
//    				access.query(sql3);	
//    				while(access.rs.next()){
//    					if(access.rs.getString(4).equals(name_in.getText().trim())&&access.rs.getString(5).equals(password_in.getText().trim())){
//    						//JOptionPane.showMessageDialog(pan1, "pass");
//    						JTabbedPane jp = new JTabbedPane();
//    						break loop;
//    					}
//    				}
//    			}
//    			catch(Exception ex){
//    				System.out.println("Database");
//    			}
//    			JOptionPane.showMessageDialog(pan1, "用户名或密码错误");
//    			name_in.setText("");
//    			password_in.setText("");
//    		}
//    		else if(rb2.isSelected()){  
//    			Access access = new Access();
//    			access.init(sql1);
//    			try{
//    				access.query(sql2);
//    				while(access.rs.next()){
//    					if(access.rs.getString(4).equals(name_in.getText().trim())&&access.rs.getString(5).equals(password_in.getText().trim())){
//    						//JOptionPane.showMessageDialog(pan1, "pass");
//    						JTabbedPane jp = new JTabbedPane();
//    						break loop;
//    					}
//    				}
//    			}
//    			catch(Exception ex){
//    				System.out.println("Database");
//    			}
//    			JOptionPane.showMessageDialog(pan1, "用户名或密码错误");
//    			name_in.setText("");
//    			password_in.setText("");
//           	}
//        }else 
        	if(e.getActionCommand() == "重置"){  
                 clear();  
        	} 
    	}  }  
}
