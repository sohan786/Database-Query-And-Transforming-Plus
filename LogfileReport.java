import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class LogfileReport extends JFrame
{
DefaultTableModel grid;
JTable table;
JScrollPane pane;
String header[]={"USER_ID","DBTYPE"};
public void display()
{
grid=new DefaultTableModel(header,0);
table=new JTable(grid);
pane=new JScrollPane(table);

add(pane);
showRecs();
setSize(1280,800);
setVisible(true);
}
void showRecs()
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select *from logfile");
while(rs.next())
{
String arg[]={"",""};
arg[0]=rs.getString(1);
arg[1]=rs.getString(2);
grid.addRow(arg);
}
}
catch(Exception ee)
{
System.out.println(ee);
}
}
public static void main(String aa[])
{
LogfileReport lfr=new LogfileReport();
lfr.display();
}
}
