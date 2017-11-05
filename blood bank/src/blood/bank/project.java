/*
 * blood bank management created by kuttyselva
 */
package blood.bank;

/**
 *
 * @author KUTTY SELVA
 */
import java.sql.*;
import java.util.*;
public class project extends BloodBank
{
    public static void main()
    {
        Connection c=null;
        Statement s=null;
        try{
            Class.forName("org.sqlite.JDBC");
    c=DriverManager.getConnection("jdbc:sqlite:blood.db");
    c.setAutoCommit(true);
    s = c.createStatement();
ResultSet rs = s.executeQuery( "SELECT * FROM bloodtab;" );
while ( rs.next() )
{
int id = rs.getInt("id");
String name = rs.getString("dname");
int age = rs.getInt("age");
String adr = rs.getString("adr");
int amt = rs.getInt("amt");
String gen = rs.getString("gr");
int pno = rs.getInt("pno");
String grp = rs.getString("bg");
System .out.println( "ID = " + id );
System .out.println( "NAME = " + name );
System .out.println( "AGE = " + age );
System .out.println( "ADDRESS = " + adr );
System .out.println( "BLOOD GROUP = " +grp );
System .out.println( "DONATED = " +amt );
System .out.println( "GENDER = " +gen );
System .out.println( "PHONE = " +pno );

System .out.println();
}
rs.close();
s.close();
c.close();
} catch ( Exception e ) {
System .err.println( e.getClass().getName() + ": " + e.getMessage() );
System .exit(0);
}

        }
    }
    
    
