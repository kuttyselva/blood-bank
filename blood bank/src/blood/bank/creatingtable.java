/*
 creating table for blood management 
 created by kuttyselva
 */
package blood.bank;

/**
 *
 * @author KUTTY SELVA
 */
import java.sql.*;
public class creatingtable extends BloodBank
{
    public static void main()
    {
    Connection c=null;
    Statement st=null;
    
    try{
    Class.forName("org.sqlite.JDBC");
    c=DriverManager.getConnection("jdbc:sqlite:blood.db");
            System.out.println("db opened successfully");
            st=c.createStatement();
            String crt="create table IF NOT EXISTS bloodtab(id number(10),dname varchar(20),age number(10),gr varchar(10),bg varchar(20),amt number(10),adr varchar(20),pno number(10));";
            st.executeUpdate(crt);
            
            
             System.out.println ("table created");
}catch(Exception e)
{
    System.err.println(e.getClass().getName()+":"+e.getMessage());
    System.exit(0);
}
   
}
}
