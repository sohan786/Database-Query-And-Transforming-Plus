import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class LogfileReportByUserID extends JFrame
{
DefaultTableModel grid;
JTable table;
JScrollPane pane;
String header[]={"USER_ID","DBTYPE"};
public void display(String key)
{
grid=new DefaultTableModel(header,0);
table=new JTable(grid);
pane=new JScrollPane(table);

add(pane);
showRecs(key);
setSize(1280,800);
setVisible(true);
}
void showRecs(String key)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select *from logfile where userid='"+key+"'");
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
LogfileReportByUserID lfr=new LogfileReportByUserID();
lfr.display("");
}
}
