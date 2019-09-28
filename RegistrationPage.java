import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
class RegistrationPage extends JFrame implements ActionListener,FocusListener
{
static int chk=0;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l11;
//JLabel l9;
JLabel lc1,lc2,lc3,lc4,lc5,lc6;
JTextField t1,t3,t4,t5,t6;
JPasswordField t2;
JRadioButton r1,r2;
JButton b1,b2,b3;
JComboBox c1,c2,c3;
ButtonGroup bg;
ImageIcon img=new ImageIcon("register.png");
ImageIcon img2=new ImageIcon("regback1.jpg");
ImageIcon img3=new ImageIcon("user2.png");
Container cnt;

void input1()
{
cnt=super.getContentPane();
cnt.setLayout(null);
Toolkit kit=Toolkit.getDefaultToolkit();
int width=(int)kit.getScreenSize().getWidth();
int height=(int)kit.getScreenSize().getHeight();
Font f=new Font("Arial",Font.BOLD,16);
l1=new JLabel("User ID");
l2=new JLabel("Password");
l3=new JLabel("Name");
l4=new JLabel("Gender");
l5=new JLabel("D.O.B");
l6=new JLabel("Organisation");
l7=new JLabel("Post");
l8=new JLabel("Department");
//l9=new JLabel(img);
l10=new JLabel(img2);
l11=new JLabel(img3);

b1=new JButton("Log in");
t1=new JTextField("");
t2=new JPasswordField("");
t3=new JTextField("");
r1=new JRadioButton("MALE");
r2=new JRadioButton("FEMALE");
bg=new ButtonGroup();
bg.add(r1);
bg.add(r2);
String str1[]={"--YEAR--","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
c1=new JComboBox(str1);
String str2[]={"--MONTH--","01","02","03","04","05","06","07","08","09","10","11","12"};
c2=new JComboBox(str2);
String str3[]={"--DATE--","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","22","23","24","25","26","27","28","29","30","31"};
c3=new JComboBox(str3);
t4=new JTextField("");
t5=new JTextField("");
t6=new JTextField("");

b2=new JButton("Register");
b3=new JButton("Reset");
lc1=new JLabel("");
lc2=new JLabel("");
lc3=new JLabel("");
lc4=new JLabel("");
lc5=new JLabel("");
lc6=new JLabel("");
l1.setFont(f);
l2.setFont(f);
l3.setFont(f);
l4.setFont(f);
l5.setFont(f);
l6.setFont(f);
l7.setFont(f);
l8.setFont(f);
b1.setFont(f);
b2.setFont(f);
b3.setFont(f);

//l9.setBounds(0,80,800,100);
b1.setBounds(1160,10,100,30);
l1.setBounds(100,250,100,30);t1.setBounds(220,250,200,30);lc1.setBounds(440,250,150,30);
l2.setBounds(100,300,100,30);t2.setBounds(220,300,200,30);lc2.setBounds(440,300,150,30);
l3.setBounds(100,350,100,30);t3.setBounds(220,350,200,30);lc3.setBounds(440,350,150,30);
l4.setBounds(100,400,100,30);r1.setBounds(220,400,150,30);r2.setBounds(380,400,150,30);
l5.setBounds(100,450,100,30);c1.setBounds(220,450,100,30);c2.setBounds(340,450,100,30);c3.setBounds(460,450,100,30);
l6.setBounds(100,500,100,30);t4.setBounds(220,500,200,30);lc4.setBounds(440,500,150,30);
l7.setBounds(100,550,100,30);t5.setBounds(220,550,200,30);lc5.setBounds(440,550,150,30);
l8.setBounds(100,600,100,30);t6.setBounds(220,600,200,30);lc6.setBounds(440,600,150,30);
b2.setBounds(220,650,100,30);b3.setBounds(360,650,100,30);
l10.setBounds(0,0,1280,800);
l11.setBounds(800,250,380,320);

//cnt.add(l9);
cnt.add(b1);
cnt.add(l1);
cnt.add(t1);
cnt.add(l2);
cnt.add(t2);
cnt.add(l3);
cnt.add(t3);
cnt.add(l4);
cnt.add(r1);
cnt.add(r2);
cnt.add(l5);
cnt.add(c1);
cnt.add(c2);
cnt.add(c3);
cnt.add(l6);
cnt.add(t4);
cnt.add(l7);
cnt.add(t5);
cnt.add(l8);
cnt.add(t6);
cnt.add(b2);
cnt.add(b3);
cnt.add(l11);
cnt.add(lc1);
cnt.add(lc2);
cnt.add(lc3);
cnt.add(lc4);
cnt.add(lc5);
cnt.add(lc6);
cnt.add(l10);

l1.setForeground(Color.black);
l2.setForeground(Color.black);
l3.setForeground(Color.black);
l4.setForeground(Color.black);
l5.setForeground(Color.black);
l6.setForeground(Color.black);
l7.setForeground(Color.black);
l8.setForeground(Color.black);
lc1.setForeground(Color.red);
lc2.setForeground(Color.red);
lc3.setForeground(Color.red);
lc4.setForeground(Color.red);
lc5.setForeground(Color.red);
lc6.setForeground(Color.red);

setSize(width,height);
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
t1.addFocusListener(this);
t2.addFocusListener(this);
t3.addFocusListener(this);
t4.addFocusListener(this);
t5.addFocusListener(this);
t6.addFocusListener(this);
}

public void checkblank(JTextField tt,JLabel lc,String msg)
	{
//chk=0;
		 String val=tt.getText();
		 if(val.length()==0)
			{
			  lc.setText(msg);
			  chk=1;
			}
		 else
			{ 
			lc.setText("");
			chk=0;
			}
	}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{

LoginPage ll=new LoginPage();
ll.input();
setVisible(false);
}


else if(ae.getSource()==b2)
{
if(chk==0)
{
String d="";
String a=t1.getText();
String b=t2.getText();
String c=t3.getText();
if(r1.isSelected())
{
d=r1.getText();
}
else if(r2.isSelected())
{
d=r2.getText();
}
String e1=c1.getSelectedItem().toString();
String e2=c2.getSelectedItem().toString();
String e3=c3.getSelectedItem().toString();
String e=e1+"-"+e2+"-"+e3;
String f=t4.getText();
String g=t5.getText();
String h=t6.getText();
if(a.length()!=0&&b.length()!=0&&c.length()!=0&&f.length()!=0&&g.length()!=0&&h.length()!=0)
{
RegistrationDB dd=new RegistrationDB();
dd.insert(a,b,c,d,e,f,g,h);
}
else
{
JOptionPane.showMessageDialog(null,"Fill all Fields");
}
}

else
{
JOptionPane.showMessageDialog(null,"Checks Fields");
}


}
else if(ae.getSource()==b3)
{
t1.setText("");
t2.setText("");
t3.setText("");
bg.clearSelection();
c1.setSelectedIndex(0);
c2.setSelectedIndex(0);
c3.setSelectedIndex(0);
t4.setText("");
t5.setText("");
t6.setText("");
}
}
public void focusGained(FocusEvent fe)
{
if(fe.getComponent()==t1)
{
t1.setBackground(Color.gray);
t1.setForeground(Color.white);
}
else if(fe.getComponent()==t2)
{
t2.setBackground(Color.gray);
t2.setForeground(Color.white);
}
else if(fe.getComponent()==t3)
{
t3.setBackground(Color.gray);
t3.setForeground(Color.white);
}
else if(fe.getComponent()==t4)
{
t4.setBackground(Color.gray);
t4.setForeground(Color.white);
}
else if(fe.getComponent()==t5)
{
t5.setBackground(Color.gray);
t5.setForeground(Color.white);
}
else if(fe.getComponent()==t6)
{
t6.setBackground(Color.gray);
t6.setForeground(Color.white);
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
else if(fe.getComponent()==t2)
{
t2.setBackground(Color.white);
t2.setForeground(Color.black);
checkblank(t2,lc2,"ENTER PASSWORD");
}
else if(fe.getComponent()==t3)
{
t3.setBackground(Color.white);
t3.setForeground(Color.black);
checkblank(t3,lc3,"ENTER NAME");
}
else if(fe.getComponent()==t4)
{
t4.setBackground(Color.white);
t4.setForeground(Color.black);
checkblank(t4,lc4,"ENTER ORGANISATION");
}
else if(fe.getComponent()==t5)
{
t5.setBackground(Color.white);
t5.setForeground(Color.black);
checkblank(t5,lc5,"ENTER POST");
}
else if(fe.getComponent()==t6)
{
t6.setBackground(Color.white);
t6.setForeground(Color.black);
checkblank(t6,lc6,"ENTER DEPARTMENT");
}
} 
public static void main(String aa[])
{
RegistrationPage rp=new RegistrationPage();
rp.input1();
}
}