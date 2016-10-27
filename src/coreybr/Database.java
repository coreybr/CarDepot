package coreybr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Manages connection to PostgreSQL database
 */

public class Database {

	public Database() {
	}

	/*
	 * Opens connection to database and loads Car objects
	 */
	public void connect() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"Cars\"");
			while (rs.next()) {
				//TODO Build Car instances
				System.out.println(rs.getString("car_manufacturer") + " " + rs.getString("car_model"));
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

}
