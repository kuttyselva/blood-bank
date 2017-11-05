package blood.bank;
import java.sql.*;
import java.util.*;

public class insertion {

	private static final String DB_DRIVER = "org.sqlite.JDBC";
	private static final String DB_CONNECTION = "jdbc:sqlite:blood.db";
	
	public static void main() {
            Scanner in = new Scanner(System.in);

		try {

			insertRecordIntoTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void insertRecordIntoTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
                int id,age,amt,pno;
                String name,adr,grp,gen,ch = null;
                Scanner in = new Scanner(System.in);
                do{System.out.println("enter your id:\t");
             id=in.nextInt();
             System.out.println("enter your name:\t");
             name=in.next();
             System.out.println();
             System.out.println("enter your age:\t");
             age=in.nextInt();
             System.out.println("enter your gender m/f :\t");
             gen=in.next();
             System.out.println();
             System.out.println("enter your blood group in words");
             grp=in.next();
             System.out.println();
             System.out.println("enter the amount of blood you donated (ml):\t ");
             amt=in.nextInt();
             System.out.println("enter your area:\t");
             adr=in.next();
             System.out.println();
             System.out.println("enter your phone number:\t");
             pno=in.nextInt();
             System.out.println();

		String insertTableSQL = "insert into bloodtab"
				+ "(id,dname,age,gr,bg,amt,adr,pno) VALUES"
				+ "(?,?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1,id );
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);
			preparedStatement.setString(4,gen);
                        preparedStatement.setString(5,grp);
                        preparedStatement.setInt(6,amt);
                        preparedStatement.setString(7,adr);
                        preparedStatement.setInt(8,pno);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
                        

			System.out.println("Record is inserted into table!");
                         dbConnection.commit();
                         System.out.println("do you want to insert another data? y/n");
                        ch=in.next();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

                }
                }while("y".equals(ch)||"Y".equals(ch));
                }
                
                
	
               

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	

}