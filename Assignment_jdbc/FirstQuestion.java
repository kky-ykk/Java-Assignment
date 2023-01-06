import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



class klas  {
	Connection con=null;
	Statement statement=null;
	PreparedStatement ps=null;
	
	Scanner o=new Scanner(System.in);
	
	void create()throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root123");
		
		String query="create table assignment(roll_no integer,name varchar(20));";
		
		if(con!=null) {
			
			DatabaseMetaData check= con.getMetaData();
			
			ResultSet rs=check.getTables(null, null, "assignment", null);
			if(rs.next()) {
				System.out.println("table assignment already exist!");
			}else {
				statement=con.createStatement();
				statement.execute(query);
			}
			
		}
	}
	
	void read() throws SQLException {
		String query="select * from assignment;";
		
		ps=con.prepareStatement(query);
		if(ps!=null) {
			ResultSet rs=ps.executeQuery();
			if(rs!=null) {
				System.out.println("Roll\tName");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
				}
			}
		}
		ps.close();
	}
	
	void update() throws SQLException {
		String name;
		Integer roll;
		
		System.out.println("Enter new name :");
		name=o.next();
		System.out.println("Enter roll no :");
		roll=o.nextInt();
		
		String query="update assignment set name=? where roll_no=?;";
		
		ps=con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, roll);
		
		if(ps!=null) {
			System.out.println("no of rows affected :"+ps.executeUpdate());
		}
		ps.close();
		
	}
	
	void delete() throws SQLException {
		int roll;
		
		System.out.println("Enter roll to delete : ");
		roll=o.nextInt();
		
		String query="delete from assignment where roll_no=?;";

		ps=con.prepareStatement(query);
		ps.setInt(1, roll);
		if(ps!=null) {
			System.out.println("no of rows affected :"+ps.executeUpdate());
		}
		ps.close();
	}
}


public class FirstQuestion {

	public static void main(String[] args) throws SQLException  {
		
		Scanner o=new Scanner(System.in);
		String demand="no";
		klas obj=new klas();
		int i;
		System.out.println("Create assignment table (yes/no) ;");
		demand=o.next();
		
		if(demand.equals("yes")) {
			obj.create();
			while(true) {		
				System.out.println("Enter 1(read) 2(update) 3(delete) 4(Exit):");
				i=o.nextInt();
				
				switch(i) {
					case 1:
						obj.read();
						break;
					case 2:
						obj.update();
						break;
					case 3:
						obj.delete();
						break;
					default:
						System.out.println("chose valid option!");
					case 4:
						return;
						
				}
			}
		}
		else
			System.out.println("GO AWAY!");
	}

}

