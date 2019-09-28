import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class RegistrationReportByUserID extends JFrame
{
DefaultTableModel grid;
JTable table;
JScrollPane pane;
String header[]={"USER ID","Password","Name","Gender","Date Of Birth","Organisation","Post","Department"};
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
ResultSet rs=stmt.executeQuery("select *from registrationpage where UserId='"+key+"'");
while(rs.next())
{
String arg[]={"","","","","","","",""};
arg[0]=rs.getString(1);
arg[1]=rs.getString(2);
arg[2]=rs.getString(3);
arg[3]=rs.getString(4);
arg[4]=rs.getString(5);
arg[5]=rs.getString(6);
arg[6]=rs.getString(7);
arg[7]=rs.getString(8);
grid.addRow(arg);
}
}
catch(Exception ee)
{
}
}
public static void main(String aa[])
{
RegistrationReportByUserID rr=new RegistrationReportByUserID();
rr.display("");
}
}