package Face;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class pan5 extends JFrame implements ActionListener{
	public static JButton button, button1, button2 = null;
	public pan5() {
		URL url = Thread.currentThread().getContextClassLoader().getResource("8.jpg");
		URL url1 = Thread.currentThread().getContextClassLoader().getResource("9.jpg");
		URL url2 = Thread.currentThread().getContextClassLoader().getResource("10.jpg");
		button = new JButton(new ImageIcon(url));
		button1 = new JButton(new ImageIcon(url1));
		button2 = new JButton(new ImageIcon(url2));
		button.setBackground(Color.WHITE);
		button1.setBackground(Color.WHITE);
		button2.setBackground(Color.WHITE);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame fra = new JFrame();
		fra.setTitle("ÏÂÔØ½ø¶È");
		fra.setSize(400, 400);
		fra.setLocation(500, 200);
		fra.setVisible(true);
		
	}

}

