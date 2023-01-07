import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class operations{
	
	Scanner o=new Scanner(System.in);
	Connection con=null;
	
	public  operations() throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root123");
		System.out.println("CONNECTION ESTABLISMED SUCCESSFULLY!");
	}
	
	void insertion() throws ParseException, SQLException {
		String name,address,gender,dob,doj,dom;
		
		System.out.println("Enter name :");
		name=o.next();
		
		System.out.println("Enter address :");
		address=o.next();

		System.out.println("Enter gender :");
		gender=o.next();
		
		System.out.println("Enter dob(dd-MM-yyy) :");
		dob=o.next();
		
		System.out.println("Enter doj(dd-MM-yyy) :");
		doj=o.next();
		
		System.out.println("Enter dom(dd-MM-yyy) :");
		dom=o.next();
		
		//changing string dates to sql format dates
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");
		java.util.Date sdob=sdf.parse(dob);
		java.util.Date sdoj=sdf.parse(doj);
		java.util.Date sdom=sdf.parse(dom);
		
		long tdob=sdob.getTime();
		long tdoj=sdoj.getTime();
		long tdom=sdom.getTime();

		java.sql.Date ddob=new java.sql.Date(tdob);
		java.sql.Date ddoj=new java.sql.Date(tdoj);
		java.sql.Date ddom=new java.sql.Date(tdom);
		
		String query="insert into assignment2 values(?,?,?,?,?,?);";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		if(ps!=null) {
			
			ps.setString(1, name);
			ps.setString(2,address);
			ps.setString(3, gender);
			ps.setDate(4, ddob);
			ps.setDate(5, ddoj);
			ps.setDate(6 , ddom);	
			
			System.out.println(ps.executeUpdate());
		}
		
		ps.close();
	}

	void retrieval() throws SQLException {
		String name;
		
		System.out.println(":enter name to retriev :");
		
		name=o.next();
		
		PreparedStatement ps=con.prepareStatement("select * from assignment2 where name=?;");
		
		if(ps!=null) {
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			if(ps!=null) {
				if(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4)+"\t"+rs.getDate(5)+rs.getDate(6));
				}
			}
		}
		
	}
		
	
}


public class SecondQuestion {

	public static void main(String[] args) throws ParseException, SQLException {
		operations obj=new operations();
		obj.insertion();
		obj.retrieval();
	}

}

