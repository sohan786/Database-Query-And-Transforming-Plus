import java.sql.*;
import javax.swing.*;

class LoginVerify
{
boolean bool;
static String userid=""; 


public boolean check(String id,String pwd,String type)
{

if(type.equals("User"))
{

try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select *from registrationpage where USERID='"+id+"' AND PASSWORD='"+pwd+"'");
System.out.println("id="+id + "password="+ pwd);
if(rs.next())
{
bool=true;
userid=id;
PlatformSelector pp=new PlatformSelector();
pp.input2();

PreparedStatement ps=con.prepareStatement("insert into loginpage values(?,?)");
ps.setString(1,id);
ps.setString(2,pwd);

ps.executeUpdate();
con.close();

}
else 
{
JOptionPane.showMessageDialog(null,"Invalid Login");
}

}
catch(Exception ee)
{
System.out.println("User error:-"+ee);
return bool;
}

}

else if(type.equals("Admin"))
{




try
{
Connection con=(Connection)MyConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select *from adminregistration where adminid='"+id+"' AND adminpassword='"+pwd+"'");
if(rs.next())
{
bool=true;
userid=id;
AdminHome hh=new AdminHome();
hh.display();
con.close();

}
else 
{
JOptionPane.showMessageDialog(null,"Invalid Login");
}

}
catch(Exception ee)
{
System.out.println("Admin Error:-"+ee);
return bool;
}

}

return bool;
}
}