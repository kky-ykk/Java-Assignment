import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class kakcha{
	
	Scanner o=new Scanner(System.in);
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pds=null;
	
	
	public kakcha() throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root123");
		System.out.println("Connection established!");
	}
	
	void insert() throws SQLException {
		String name,course;
		int roll;
		
		System.out.println("Enter roll :");
		roll=o.nextInt();
		
		System.out.println("Enter name : ");
		name=o.next();
		
		System.out.println("Enter course :");
		course=o.next();
		
		String query="insert into kakcha values(?,?,?);";
		
		pds=con.prepareStatement(query);
		if(pds!=null) {
			pds.setInt(1, roll);
			pds.setString(2, name);
			pds.setString(3, course);
			
			System.out.println("No of row affected is "+pds.executeUpdate());
		}
		
		pds.close();
	}
	
	void del() throws SQLException {
		int roll;
		
		System.out.println("Enter deleting roll :");
		roll=o.nextInt();
		
		String query="delete from kakcha where roll=?;";
		
		pds=con.prepareStatement(query);
		if(pds!=null) {
			pds.setInt(1, roll);
			
			System.out.println("No of row affected is "+pds.executeUpdate());
		}
		
		pds.close();
	}
	
	void update() throws SQLException {
		int roll;
		String name=null,course=null;
		
		System.out.println("Enter roll where to update :");
		roll=o.nextInt();
		
		System.out.println("Enter name :");
		name=o.next();
		
		System.out.println("Enter course : ");
		course=o.next();
		
		String query="update kakcha set name=?, course=? where roll=?";
		
		pds=con.prepareStatement(query);
		pds.setString(1,name);
		pds.setString(2, course);
		pds.setInt(3, roll);
		if(pds!=null) {
			System.out.println("no of rows affected :"+pds.executeUpdate());
		}
		pds.close();
	}
	
	void select() throws SQLException {
		int roll;
		
		System.out.println("enter roll :");
		roll=o.nextInt();
		
		String query="select * from kakcha where roll=?;";
		
		pds=con.prepareStatement(query);
		pds.setInt(1, roll);
		rs=pds.executeQuery();
		if(rs!=null) {
			System.out.println("Roll\tName\tCourse");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		}
		pds.close();
	}
	
	
	
}

public class ThirdQuestion {

	public static void main(String[] args) throws SQLException {
		Scanner o=new Scanner(System.in);
		kakcha obj=new kakcha();
		int i;
		System.out.println("CHOSE the OPTIONS");
		while(true){
			
			System.out.println("1)insert 2)update 3)select 4)del 5)exit");
			i=o.nextInt();
			switch(i) {
				case 1:
					obj.insert();
					break;
				case 2:
					obj.update();
					break;					
				case 3:
					obj.select();
					break;
				case 4:
					obj.del();
					break;
				default:
					System.out.println("Choose valid option");
					break;
				case 5:
					return;
			}
			
		}
		
	}

}

