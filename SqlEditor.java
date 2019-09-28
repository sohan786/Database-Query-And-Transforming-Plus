import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.border.*;
 class SqlEditor extends JFrame implements ActionListener
{
static String userid="";
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
ImageIcon img1=new ImageIcon("wordpic.jpg");
ImageIcon img2=new ImageIcon("excelpic.jpg");
ImageIcon img3=new ImageIcon("xmlpic.jpg");
ImageIcon img4=new ImageIcon("htmlpic.jpg");
ImageIcon img5=new ImageIcon("logout.jpg");
ImageIcon img6=new ImageIcon("regback2.jpg");
ImageIcon img7=new ImageIcon("history.jpg");
ImageIcon img8=new ImageIcon("sql.png");
ImageIcon img9=new ImageIcon("back.jpg");

JTextArea ta;
JButton b1,b2;
DefaultTableModel grid;
JTable tab;
JScrollPane tabpan;
String header[]={"column1","column2","column3"};

void display()
{
userid=LoginVerify.userid;
grid=new DefaultTableModel(header,2);
tab=new JTable(grid);
tabpan=new JScrollPane(tab);


ta=new JTextArea("Enter query to be executed");
tab.setRowHeight(20);
Font f=new Font("Arial",Font.BOLD,18);
ta.setFont(f);
b1=new JButton("Execute");
b2=new JButton("Clear");
l1=new JLabel(img1);
l2=new JLabel(img2);
l3=new JLabel(img3);
l4=new JLabel(img4);
l6=new JLabel(img5);
l5=new JLabel("Welcome ID:-"+userid);
l7=new JLabel(img6);
l8=new JLabel(img7);
l9=new JLabel(img8);
l10=new JLabel(img9);

l5.setFont(f);
b1.setFont(f);
b2.setFont(f);

l9.setBounds(300,10,600,70);
l5.setBounds(10,10,300,50);
l8.setBounds(1150,10,100,30);
l10.setBounds(1150,60,100,30);
l6.setBounds(1150,110,100,30);
ta.setBounds(100,100,1010,300);
b1.setBounds(100,450,150,60); b2.setBounds(280,450,150,60);l1.setBounds(450,450,150,60);l2.setBounds(620,450,150,60);l3.setBounds(790,450,150,60);l4.setBounds(960,450,150,60);l7.setBounds(0,0,1280,800);
tabpan.setBounds(100,550,1010,300);

add(l8);
add(l9);
add(l10);
add(l6);
add(l5);
add(ta);
add(b1);
add(b2);
add(l1);
add(l2);
add(l3);
add(l4);
add(tabpan);
add(l7);

ta.setBackground(Color.blue);
ta.setForeground(Color.white);
ta.setBorder(BorderFactory.createLineBorder(Color.black));
l1.setBorder(BorderFactory.createLineBorder(Color.gray));
l2.setBorder(BorderFactory.createLineBorder(Color.black));
l3.setBorder(BorderFactory.createLineBorder(Color.red));
l4.setBorder(BorderFactory.createLineBorder(Color.blue));
l6.setBorder(BorderFactory.createLineBorder(Color.red));
l8.setBorder(BorderFactory.createLineBorder(Color.red));
l10.setBorder(BorderFactory.createLineBorder(Color.red));

setSize(1280,800);
setLayout(null);
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
l8.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
QueryReportByID dd=new QueryReportByID();
dd.display(userid);
}
});
l10.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
PlatformSelector dd=new PlatformSelector();
dd.input2();
setVisible(false);
}
}
);
l6.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement("insert into logoff values (?,?)");
ps.setString(1,userid);
ps.setString(2,"SQL");
ps.executeUpdate();
}
catch(Exception ee)
{
System.out.println(ee);
}
LoginPage ll=new LoginPage();
ll.input();
setVisible(false);
}
}
);
ta.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
String str=ta.getText();
if(str.equals("Enter query to be executed"))
ta.setText("");
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
l1.setBorder(BorderFactory.createLineBorder(Color.gray));
}
public void mouseClicked(MouseEvent me)
{
String query=ta.getText();
if (query.startsWith("S") || query.startsWith("s"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
ResultSetMetaData cols=rs.getMetaData();
int cno=cols.getColumnCount();
String coln[]=new String[cno];
String name=JOptionPane.showInputDialog(null,"Enter File name");
FileOutputStream fos=new FileOutputStream(name+".doc");
PrintWriter pxl=new PrintWriter(fos);
pxl.println("<table border='1' width='100%'>");
pxl.println("<tr bgcolor='gray'>");
for(int ii=1;ii<=cno;ii++)
{
coln[ii-1]=cols.getColumnName(ii);
pxl.println("<td><b>"+coln[ii-1]+"</b></td>");

}
pxl.println("</tr>");
grid=new DefaultTableModel(coln,0);

String row[]=new String[cno];
while(rs.next())
{
pxl.println("<tr>");
for(int jj=1;jj<=cno;jj++)
{
row[jj-1]=rs.getString(jj);
pxl.println("<td><b>"+row[jj-1]+"</b></td>");
}
pxl.println("</tr>");
}
pxl.println("</table>");
con.close();
pxl.close();
JOptionPane.showMessageDialog(null,"SuccessFully Transformed As File Name= "+name+".doc");
}
catch(Exception ee)
{
System.out.println(ee);
}

}
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
public void mouseClicked(MouseEvent me)
{
String query=ta.getText();
if (query.startsWith("S") || query.startsWith("s"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
ResultSetMetaData cols=rs.getMetaData();
int cno=cols.getColumnCount();
String coln[]=new String[cno];
String name=JOptionPane.showInputDialog(null,"Enter File name");
FileOutputStream fos=new FileOutputStream(name+".xls");
PrintWriter pxl=new PrintWriter(fos);
pxl.println("<table>");
pxl.println("<tr>");
for(int ii=1;ii<=cno;ii++)
{
coln[ii-1]=cols.getColumnName(ii);
pxl.println("<td><b>"+coln[ii-1]+"</b></td>");

}
pxl.println("</tr>");
grid=new DefaultTableModel(coln,0);

String row[]=new String[cno];
while(rs.next())
{
pxl.println("<tr>");
for(int jj=1;jj<=cno;jj++)
{
row[jj-1]=rs.getString(jj);
pxl.println("<td><b>"+row[jj-1]+"</b></td>");
}
pxl.println("</tr>");
}
pxl.println("</table>");
con.close();
pxl.close();
JOptionPane.showMessageDialog(null,"SuccessFully Transformed As File Name= "+name+".xls");
}
catch(Exception ee)
{
System.out.println(ee);
}

}
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
public void mouseClicked(MouseEvent me)
{
String query=ta.getText();
if (query.startsWith("S") || query.startsWith("s"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
ResultSetMetaData cols=rs.getMetaData();
int cno=cols.getColumnCount();
String coln[]=new String[cno];
String name=JOptionPane.showInputDialog(null,"Enter File name");
FileOutputStream fos=new FileOutputStream(name+".xml");
PrintWriter pxl=new PrintWriter(fos);
pxl.println("<table>");
pxl.println("<tr>");
for(int ii=1;ii<=cno;ii++)
{
coln[ii-1]=cols.getColumnName(ii);
pxl.println("<td><b>"+coln[ii-1]+"</b></td>");

}
pxl.println("</tr>");
grid=new DefaultTableModel(coln,0);

String row[]=new String[cno];
while(rs.next())
{
pxl.println("<tr>");
for(int jj=1;jj<=cno;jj++)
{
row[jj-1]=rs.getString(jj);
pxl.println("<td><b>"+row[jj-1]+"</b></td>");
}
pxl.println("</tr>");
}
pxl.println("</table>");
con.close();
pxl.close();
JOptionPane.showMessageDialog(null,"SuccessFully Transformed As File Name= "+name+".xml");
}
catch(Exception ee)
{
System.out.println(ee);
}

}
}
}
);
l4.addMouseListener(
new MouseAdapter()
{
public void mouseEntered(MouseEvent me)
{
l4.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
}
public void mouseExited(MouseEvent me)
{
l4.setBorder(BorderFactory.createLineBorder(Color.blue));
}
public void mouseClicked(MouseEvent me)
{
String query=ta.getText();
if (query.startsWith("S") || query.startsWith("s"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
ResultSetMetaData cols=rs.getMetaData();
int cno=cols.getColumnCount();
String coln[]=new String[cno];
String name=JOptionPane.showInputDialog(null,"Enter File name");
FileOutputStream fos=new FileOutputStream(name+".html");
PrintWriter pxl=new PrintWriter(fos);
pxl.println("<table>");
pxl.println("<tr>");
for(int ii=1;ii<=cno;ii++)
{
coln[ii-1]=cols.getColumnName(ii);
pxl.println("<td><b>"+coln[ii-1]+"</b></td>");

}
pxl.println("</tr>");
grid=new DefaultTableModel(coln,0);

String row[]=new String[cno];
while(rs.next())
{
pxl.println("<tr>");
for(int jj=1;jj<=cno;jj++)
{
row[jj-1]=rs.getString(jj);
pxl.println("<td><b>"+row[jj-1]+"</b></td>");
}
pxl.println("</tr>");
}
pxl.println("</table>");
con.close();
pxl.close();
JOptionPane.showMessageDialog(null,"SuccessFully Transformed As File Name= "+name+".html");
}
catch(Exception ee)
{
System.out.println(ee);
}

}
}
}
);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String query=ta.getText().trim();
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement("insert into logininfo values (?,?)");
ps.setString(1,userid);
ps.setString(2,query);
ps.executeUpdate();
con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
if(query.startsWith("C")||query.startsWith("c")||query.startsWith("I")||query.startsWith("i")||query.startsWith("U")||query.startsWith("u")||query.startsWith("D")||query.startsWith("d")||query.startsWith("t")||query.startsWith("T"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement(query);
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"SuccessFully executed");
}
catch(Exception ee)
{
JOptionPane.showMessageDialog(null,ee);
}
}
else if(query.startsWith("S")||query.startsWith("s"))
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
ResultSetMetaData cols=rs.getMetaData();
int cno=cols.getColumnCount();
String coln[]=new String[cno];
for(int ii=1;ii<=cno;ii++)
{
coln[ii-1]=cols.getColumnName(ii);
}
grid=new DefaultTableModel(coln,0);

String row[]=new String[cno];
while(rs.next())
{
for(int jj=1;jj<=cno;jj++)
{
row[jj-1]=rs.getString(jj);
}
grid.addRow(row);
}
tab.setModel(grid);
con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}
}
else if(ae.getSource()==b2)
{
ta.setText("");
}
}
public static void main(String aa[])
{
SqlEditor se=new SqlEditor();
se.display();
}
}