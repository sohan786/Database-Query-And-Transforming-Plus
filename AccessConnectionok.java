import java.sql.*;
class AccessConnectionok
{
public static Connection getConnection()
{
try
{
Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/NIRAJ/Documents/sohan.accdb");
System.out.println("ok");
return con;
}
catch(Exception ee)
{
System.out.println(ee);
return null;
}
} 
}