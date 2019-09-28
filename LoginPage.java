import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
class LoginPage extends JFrame implements ActionListener,FocusListener
{
static int chk=0;
JLabel l1,l2,l4,l5,l6;
JLabel lc1,lc2;
JComboBox c1;
ImageIcon img2=new ImageIcon("dbms3.jpg");
JTextField t1;
JPasswordField p1;
JButton b1,b2;
Container cnt;

void input()
{
cnt=super.getContentPane();
cnt.setLayout(null);
Toolkit kit=Toolkit.getDefaultToolkit();
int width=(int)kit.getScreenSize().getWidth();
int height=(int)kit.getScreenSize().getHeight(); 
Font f=new Font("Arial",Font.BOLD,18);
l1=new JLabel("User ID");
l2=new JLabel("Password");
l4=new JLabel("Register Now");
l5=new JLabel(img2);
l6=new JLabel("Select Type");
String str[]={"--Select--","User","Admin"};
c1=new JComboBox(str);
t1=new JTextField("");
p1=new JPasswordField("");
b1=new JButton("LOG IN");
b2=new JButton("RESET");
lc1=new JLabel("");
lc2=new JLabel("");
l1.setFont(f);
l2.setFont(f);
l4.setFont(f);
l6.setFont(f);
b1.setFont(f);
b2.setFont(f);


l5.setBounds(0,0,1280,800);
l1.setBounds(120,340,150,30);t1.setBounds(300,340,150,30);lc1.setBounds(480,340,150,30);
l2.setBounds(120,390,150,30);p1.setBounds(300,390,150,30);lc2.setBounds(480,390,150,30);
l6.setBounds(120,440,150,30);c1.setBounds(300,440,150,30);
b1.setBounds(120,530,150,30);b2.setBounds(300,530,150,30);l4.setBounds(520,520,120,50);

cnt.add(l1);
cnt.add(l2);
cnt.add(t1);
cnt.add(p1);
cnt.add(b1);
cnt.add(lc1);
cnt.add(lc2);
cnt.add(b2);
cnt.add(l4);
cnt.add(l6);
cnt.add(c1);
cnt.add(l5);
l1.setForeground(Color.black);
l2.setForeground(Color.black);
l4.setForeground(Color.black);
l6.setForeground(Color.black);
lc1.setForeground(Color.red);
lc2.setForeground(Color.red);

setSize(1280,800);
setVisible(true);

l4.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
RegistrationPage rp=new RegistrationPage();
rp.input1();
setVisible(false);

}
public void mouseEntered(MouseEvent me)
{
l4.setForeground(Color.red);
}
public void mouseExited(MouseEvent me)
{
l4.setForeground(Color.black);
}
}
);
b1.addActionListener(this);
b2.addActionListener(this);
t1.addFocusListener(this);
p1.addFocusListener(this);
}
public void checkblank(JTextField tt,JLabel lc,String msg)
	{
chk=0;
		 String val=tt.getText();
		 if(val.length()==0)
			{
			  lc.setText(msg);
			  chk=1;
			}
		 else
			{ 
			lc.setText("");
		
			}
	}
                          
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
if(chk==0)
{
String a=t1.getText();
String b=p1.getText();
String c=c1.getSelectedItem().toString();
if(a.length()!=0&&b.length()!=0&&c.length()!=0)
{
LoginVerify lv=new LoginVerify();
boolean bool=lv.check(a,b,c);
if(bool)
{
setVisible(false);
}
}
else
{
JOptionPane.showMessageDialog(null,"Fill all Fields");
}
}
else 
{
JOptionPane.showMessageDialog(null,"check fields");
}
}
else if(ae.getSource()==b2)
{
t1.setText("");
p1.setText("");
c1.setSelectedIndex(0);
}
}
public void focusGained(FocusEvent fe)
{
if(fe.getComponent()==t1)
{
t1.setBackground(Color.gray);
t1.setForeground(Color.white);
}
else if(fe.getComponent()==p1)
{
p1.setBackground(Color.gray);
p1.setForeground(Color.white);
}
}
public void focusLost(FocusEvent fe)
{
if(fe.getComponent()==t1)
{
t1.setBackground(Color.white);
t1.setForeground(Color.black);
checkblank(t1,lc1,"ENTER USER ID");
}
else if(fe.getComponent()==p1)
{
p1.setBackground(Color.white);
p1.setForeground(Color.black);
checkblank(p1,lc2,"ENTER PASSWORD");
}
}
public static void main(String aa[])
{
LoginPage lp=new LoginPage();
lp.input();
}                                                                 }  