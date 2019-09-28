import java.sql.*;
import javax.swing.*;
class RegistrationDB
{
public void insert(String a,String b,String c,String d,String e,String f,String g,String h)
{
try
{
Connection con=(Connection)MyConnection.getConnection();
PreparedStatement ps=con.prepareStatement("insert into registrationpage values(?,?,?,?,?,?,?,?)");
ps.setString(1,a);
ps.setString(2,b);
ps.setString(3,c);
ps.setString(4,d);
ps.setString(5,e);
ps.setString(6,f);
ps.setString(7,g);
ps.setString(8,h);
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"SuccessFully Registered");
con.close();
}
catch(Exception ee)
{
JOptionPane.showMessageDialog(null,"ID Already Exist:-"+ee);
}
}
}