import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
class PlatformSelector extends JFrame
{
static String userid="";
JLabel l1,l2,l3,l5,l6;
Container cnt;
ImageIcon img1=new ImageIcon("oracle2.jpg");
ImageIcon img2=new ImageIcon("mysql2.jpg");
ImageIcon img3=new ImageIcon("access.jpg");
ImageIcon img5=new ImageIcon("platback.jpg");
ImageIcon img6=new ImageIcon("logout.jpg");

void input2()
{
userid=LoginVerify.userid;
cnt=super.getContentPane();
cnt.setLayout(null);
Toolkit kit=Toolkit.getDefaultToolkit();
int width=(int)kit.getScreenSize().getWidth();
int height=(int)kit.getScreenSize().getHeight();
l1=new JLabel(img1);
l2=new JLabel(img2);
l3=new JLabel(img3);
l5=new JLabel(img5);
l6=new JLabel(img6);

l6.setBounds(1150,10,100,30);
l1.setBounds(150,250,300,250);l2.setBounds(500,250,300,250);
l3.setBounds(850,250,300,250);l5.setBounds(0,0,width,800);

cnt.add(l1);
cnt.add(l2);
cnt.add(l3);
cnt.add(l6);
l1.setBorder(BorderFactory.createLineBorder(Color.green));
l2.setBorder(BorderFactory.createLineBorder(Color.black));
l3.setBorder(BorderFactory.createLineBorder(Color.red));
l6.setBorder(BorderFactory.createLineBorder(Color.red));
cnt.add(l5);
setSize(width,height);
setVisible(true);
l6.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
LoginPage ll=new LoginPage();
ll.input();
setVisible(false);
}
}
);
l1.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement("insert into logfile values (?,?)");
ps.setString(1,userid);
ps.setString(2,"oracle");
ps.executeUpdate();
}
catch(Exception ee)
{
System.out.println(ee);
}
OracleEditor oe=new OracleEditor();
oe.display();
setVisible(false);
}
}
);
l2.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement("insert into logfile values (?,?)");
ps.setString(1,userid);
ps.setString(2,"mysql");
ps.executeUpdate();
}
catch(Exception ee)
{
System.out.println(ee);
}
SqlEditor oe=new SqlEditor();
oe.display();
setVisible(false);
}
}
);
l3.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
AccessEditor ll=new AccessEditor();
ll.display();
setVisible(false);
}
}
);
l1.addMouseListener(
new MouseAdapter()
{
public void mouseEntered(MouseEvent me)
{
l1.setBorder(BorderFactory.createLineBorder(new Color(34,120,200)));
}
public void mouseExited(MouseEvent me)
{
l1.setBorder(BorderFactory.createLineBorder(Color.green));
}
}
);
l2.addMouseListener(
new MouseAdapter()
{
public void mouseEntered(MouseEvent me)
{
l2.setBorder(BorderFactory.createLineBorder(new Color(254,0,200)));
}
public void mouseExited(MouseEvent me)
{
l2.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
);
l3.addMouseListener(
new MouseAdapter()
{
public void mouseEntered(MouseEvent me)
{
l3.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
}
public void mouseExited(MouseEvent me)
{
l3.setBorder(BorderFactory.createLineBorder(Color.red));
}
}
);
}
public static void main(String aa[])
{
PlatformSelector ps=new PlatformSelector();
ps.input2();
}
}