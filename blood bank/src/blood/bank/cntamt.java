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
public class cntamt extends BloodBank
{
    public static void main()
    {
        Scanner in = new Scanner(System.in);
        Connection c=null;
        Statement s=null;
        try{
            Class.forName("org.sqlite.JDBC");
    c=DriverManager.getConnection("jdbc:sqlite:blood.db");
    c.setAutoCommit(true);
    s = c.createStatement();
    
ResultSet rs = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='opv';" );
while ( rs.next() )
{
int id = rs.getInt("op");
System .out.println( "amout of O positive  = " +id );
}
ResultSet rp = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='oneg';" );
while ( rp.next() )
{
int id = rp.getInt("op");
System .out.println( "amount of O negative = " +id );
}
ResultSet rq = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='bpos';" );
while ( rq.next() )
{
int id = rq.getInt("op");
System .out.println( "amout of B positive = " +id );
}
ResultSet rr = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='bneg';" );
while ( rr.next() )
{
int id = rr.getInt("op");
System .out.println( "amout of B negative = " +id );
}
ResultSet rt = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='abpos';" );
while ( rt.next() )
{
int id = rt.getInt("op");
System .out.println( "amout of AB positive = " +id );
}
ResultSet ru = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='abneg';" );
while ( ru.next() )
{
int id = ru.getInt("op");
System .out.println( "amout of AB negative = " +id );
}
ResultSet rv = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='apos';" );
while ( rv.next() )
{
int id = rv.getInt("op");
System .out.println( "amout of A positive = " +id );
}
ResultSet rw = s.executeQuery( "SELECT sum(amt) as op FROM bloodtab where bg='aneg';" );
while ( rw.next() )
{
int id = rw.getInt("op");
System .out.println( "amout of A negative = " +id );
}
System .out.println();

rs.close();
s.close();
c.close();
} catch ( Exception e ) {
System .err.println( e.getClass().getName() + ": " + e.getMessage() );
System .exit(0);
}

        }
    }
    
    
