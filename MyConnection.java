import java.sql.*;
class MyConnection
{
public static Connection getConnection()
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
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