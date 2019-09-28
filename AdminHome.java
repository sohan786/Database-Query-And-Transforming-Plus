import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class AdminHome extends JFrame implements ActionListener
{
JMenu ma,mb,mc;
JMenuItem maa,mab,mac,mad;
JMenuItem mba,mbb,mbc,mbd,mbe;
JMenuItem mca;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
ImageIcon img1=new ImageIcon("searchforregs1.jpg");
ImageIcon img2=new ImageIcon("searchforlogin1.jpg");
ImageIcon img3=new ImageIcon("searchforquery1.jpg");
ImageIcon img4=new ImageIcon("searchforlogout1.jpg");
ImageIcon img5=new ImageIcon("reportofps.jpg");
ImageIcon img6=new ImageIcon("reportofquery.jpg");
ImageIcon img7=new ImageIcon("reportoflogin.jpg");
ImageIcon img8=new ImageIcon("reportoflogout.jpg");
ImageIcon img9=new ImageIcon("reportofregs.jpg");
ImageIcon img10=new ImageIcon("adminback3.jpg");
ImageIcon img11=new ImageIcon("regback2.jpg");
ImageIcon img12=new ImageIcon("poweroff.png");

void display()
{
ma=new JMenu("Search");
mb=new JMenu("Report");
mc=new JMenu("Logout");
maa=new JMenuItem("For Registration");
mab=new JMenuItem("For Login");
mac=new JMenuItem("For Query");
mad=new JMenuItem("For Logout");
mba=new JMenuItem("Of Platform Seletion");
mbb=new JMenuItem("Of Query Info");
mbc=new JMenuItem("Of Login Info");
mbd=new JMenuItem("Of Logout Info");
mbe=new JMenuItem("Of Registration Info");
mca=new JMenuItem("Sign Out");
l10=new JLabel(img10);
l1=new JLabel(img1);
l2=new JLabel(img2);
l3=new JLabel(img3);
l4=new JLabel(img4);
l5=new JLabel(img5);
l6=new JLabel(img6);
l7=new JLabel(img7);
l8=new JLabel(img8);
l9=new JLabel(img9);
l11=new JLabel(img11);
l12=new JLabel(img12);
l13=new JLabel("VIEW FULL REPORT");
l14=new JLabel("SEARCH BY USER ID");

l1.setBorder(BorderFactory.createLineBorder(Color.black));
l2.setBorder(BorderFactory.createLineBorder(Color.black));
l3.setBorder(BorderFactory.createLineBorder(Color.black));
l4.setBorder(BorderFactory.createLineBorder(Color.black));
l5.setBorder(BorderFactory.createLineBorder(Color.black));
l6.setBorder(BorderFactory.createLineBorder(Color.black));
l7.setBorder(BorderFactory.createLineBorder(Color.black));
l8.setBorder(BorderFactory.createLineBorder(Color.black));
l9.setBorder(BorderFactory.createLineBorder(Color.black));

Font f=new Font("Arial",Font.BOLD,22);
l13.setFont(f);
l14.setFont(f);
l13.setForeground(Color.black);
l14.setForeground(Color.black);

ma.add(maa);
ma.add(mab);
ma.add(mac);
ma.add(mad);
mb.add(mba);
mb.add(mbb);
mb.add(mbc);
mb.add(mbd);
mb.add(mbe);
mc.add(mca);
JMenuBar bar=new JMenuBar();
bar.add(ma);
bar.add(mb);
bar.add(mc);
setJMenuBar(bar);
bar.setBounds(10,10,1280,10);

l10.setBounds(0,1,1280,200);
l12.setBounds(1150,140,50,50);
l13.setBounds(10,215,300,50);
l5.setBounds(100,280,200,170);l6.setBounds(330,280,200,170);l7.setBounds(560,280,200,170);l8.setBounds(790,280,200,170);l9.setBounds(1020,280,200,170);
l14.setBounds(10,465,300,50);
l1.setBounds(150,530,220,170);l2.setBounds(400,530,220,170);l3.setBounds(650,530,220,170);l4.setBounds(900,530,220,170);
l11.setBounds(0,200,1280,800);

add(l12);
add(l10);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l13);
add(l14);
add(l11);

setSize(1280,800);
setVisible(true);
setLayout(null);
maa.addActionListener(this);

mab.addActionListener(this);

mac.addActionListener(this);

mad.addActionListener(this);

mba.addActionListener(this);

mbb.addActionListener(this);

mbc.addActionListener(this);

mbd.addActionListener(this);

mbe.addActionListener(this);

mca.addActionListener(this);

l1.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
String key=JOptionPane.showInputDialog(null,"Enter user ID");
if(key.length()!=0)
{
RegistrationReportByUserID rr=new RegistrationReportByUserID();
rr.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill Information");
}
}
catch(Exception ee)
{
System.out.println(ee);
}
}
public void mouseEntered(MouseEvent me)
{
l1.setBounds(140,510,230,190);
l1.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l1.setBounds(150,530,220,170);
l1.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l2.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
String key=JOptionPane.showInputDialog(null,"Enter User ID:-");
if(key.length()!=0)
{
LogfileReportByUserID ll=new LogfileReportByUserID();
ll.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
public void mouseEntered(MouseEvent me)
{
l2.setBounds(390,510,230,190);
l2.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l2.setBounds(400,530,220,170);
l2.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l3.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
String key=JOptionPane.showInputDialog(null,"Enter User ID:-");
if(key.length()!=0)
{
QueryReportByID qq=new QueryReportByID();
qq.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
public void mouseEntered(MouseEvent me)
{
l3.setBounds(640,510,230,190);
l3.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l3.setBounds(650,530,220,170);
l3.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l4.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
String key=JOptionPane.showInputDialog(null,"Enter User ID:-");
if(key.length()!=0)
{
LogoutReportByID ll=new LogoutReportByID();
ll.display(key);
}
else 
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
public void mouseEntered(MouseEvent me)
{
l4.setBounds(890,510,230,190);
l4.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l4.setBounds(900,530,220,170);
l4.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l5.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
LogfileReport ll=new LogfileReport();
ll.display();
}
public void mouseEntered(MouseEvent me)
{
l5.setBounds(90,260,210,190);
l5.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l5.setBounds(100,280,200,170);
l5.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l6.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
LoginfoReport ll=new LoginfoReport();
ll.display();
}
public void mouseEntered(MouseEvent me)
{
l6.setBounds(320,260,210,190);
l6.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l6.setBounds(330,280,200,170);
l6.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l7.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
LoginReport ll=new LoginReport();
ll.display();
}
public void mouseEntered(MouseEvent me)
{
l7.setBounds(550,260,210,190);
l7.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l7.setBounds(560,280,200,170);
l7.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l8.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
LogoffReport ll=new LogoffReport();
ll.display();
}
public void mouseEntered(MouseEvent me)
{
l8.setBounds(780,260,210,190);
l8.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l8.setBounds(790,280,200,170);
l8.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l9.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
Connection con=(Connection)MyConnection.getConnection();
RegistrationReport ll=new RegistrationReport();
ll.display();
}
public void mouseEntered(MouseEvent me)
{
l9.setBounds(1010,260,210,190);
l9.setBorder(BorderFactory.createLineBorder(Color.red));
}
public void mouseExited(MouseEvent me)
{
l9.setBounds(1020,280,200,170);
l9.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l12.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
LoginPage ll=new LoginPage();
ll.input();
setVisible(false);
}
public void mouseEntered(MouseEvent me)
{
l12.setBounds(1140,110,90,110);
}
public void mouseExited(MouseEvent me)
{
l12.setBounds(1150,140,50,50);
}
}
);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==maa)
{
String key=JOptionPane.showInputDialog(null,"Enter user ID");
if(key.length()!=0)
{
RegistrationReportByUserID rr=new RegistrationReportByUserID();
rr.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
else if(ae.getSource()==mab)
{
String key=JOptionPane.showInputDialog(null,"Enter User ID:-");
if(key.length()!=0)
{
LogfileReportByUserID ll=new LogfileReportByUserID();
ll.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
else if(ae.getSource()==mac)
{
String key=JOptionPane.showInputDialog(null,"Enter User ID:-");
if(key.length()!=0)
{
QueryReportByID qq=new QueryReportByID();
qq.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
else if(ae.getSource()==mad)
{
String key=JOptionPane.showInputDialog(null,"Enter user ID");
if(key.length()!=0)
{
LogoutReportByID ll=new LogoutReportByID();
ll.display(key);
}
else
{
JOptionPane.showMessageDialog(null,"fill information");
}
}
else if(ae.getSource()==mba)
{
LogfileReport ll=new LogfileReport();
ll.display();
}
else if(ae.getSource()==mbb)
{
LoginfoReport ll=new LoginfoReport();
ll.display();
}
else if(ae.getSource()==mbc)
{
LoginReport ll=new LoginReport();
ll.display();
}
else if(ae.getSource()==mbd)
{
LogoffReport ll=new LogoffReport();
ll.display();
}
else if(ae.getSource()==mbe)
{
RegistrationReport ll=new RegistrationReport();
ll.display();
}
else if(ae.getSource()==mca)
{
LoginPage ll=new LoginPage();
ll.input();
setVisible(false);
}
}
public static void main(String aa[])
{
AdminHome hh=new AdminHome();
hh.display();
}
}