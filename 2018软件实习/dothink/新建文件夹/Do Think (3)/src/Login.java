import java.awt.GridLayout;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

	private JPanel pan1,pan2,pan3,pan4,pan5 = null;
	JLabel title,password = null;
	static JLabel name;
	public static JTextField name_in = null;
	JPasswordField password_in = null;
	JRadioButton rb1,rb2 = null;
	JButton b1,b2 = null;

    public static void main(String[] args) { 
    	Login mUI = new Login();  
    }  

    public Login() {  
    	JFrame frame =new JFrame();
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
        
        //清空
        b2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		clear();}
        	});
        
        //判断权限登陆
        b1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(rb1.isSelected()){
					System.out.println("xiaoshou");
					SqlOperation sale = new SqlOperation();
					try {
						String search1 = "select id,pass from user where authority = 'other' ";
						sale.operation(search1,1);
						int j=0;
						loop:while(sale.result2.next()){
							if(sale.result2.getString("id").equals(name_in.getText())&&sale.result2.getString("pass").equals(password_in.getText())){
								frame.setVisible(false);
								JTabbedpane1 jp = new JTabbedpane1();
								j=1;
								break loop;
							}
							if(j==0) {
								JOptionPane.showMessageDialog(pan1, "用户名或密码错误");
								name_in.setText("");
								password_in.setText("");
							}
						}
						sale.statement.close();
						sale.connection.close();
					}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
				else if(rb2.isSelected()){
					System.out.println("guanli");
					SqlOperation sale = new SqlOperation();
					try {
						String search1 = "select id,pass from user where authority = 'admin'";
						sale.operation(search1,1);
						int j=0;
						loop1:while(sale.result2.next()){
							if(sale.result2.getString("id").equals(name_in.getText().trim())&&sale.result2.getString("pass").equals(password_in.getText().trim())){
								excel3 ex = new excel3();
								frame.setVisible(false);
								JTabbedpane1 jp = new JTabbedpane1();
								j=1;
								break loop1;
							}
							if(j==0) {
							JOptionPane.showMessageDialog(pan1, "用户名或密码错误");
							name_in.setText("");
							password_in.setText("");
						}
						}
						sale.statement.close();
						sale.connection.close();
					}
					 catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});  
         
        frame.add(pan1);  
        frame.add(pan2);  
        frame.add(pan3);  
        frame.add(pan4);  
        frame.add(pan5);
        frame.setLayout(new GridLayout(5,1));   
        frame.setTitle("登陆Dothink销售管理系统");          
        frame.setSize(400,300);         
        frame.setLocation(400, 200);           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        frame.setResizable(false);  
    } 
    //重置
    public void clear(){  
    	name_in.setText("");  
    	password_in.setText(""); 
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}  
}