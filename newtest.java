package cn.edu.jlu.ccst.mud;
import java.sql.*;


public class newtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection cn = DriverManager.getConnection("jdbc:derby:helloDB;create=true");
		Statement st = cn.createStatement();
		st.execute("create table helloHibernate(name varchar(40),score int)");
		st.execute("insert into helloHibernate values('Ruth Cao',86)");
		st.execute("insert into helloHibernate values('Flora shi',92)");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
