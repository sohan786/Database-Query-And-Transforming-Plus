import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class QueryReportByID extends JFrame
{
DefaultTableModel grid;
JTable table;
JScrollPane pane;
String header[]={"USER_ID","QUERY"};
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
ResultSet rs=stmt.executeQuery("select *from logininfo where userid='"+key+"'");
while(rs.next())
{
String args[]={"",""};
args[0]=rs.getString(1);
args[1]=rs.getString(2);
grid.addRow(args);
}
}
catch(Exception ee)
{
System.out.println(ee);
}
}
public static void main(String aa[])
{
QueryReportByID qq=new QueryReportByID();

qq.display("");
}
}
