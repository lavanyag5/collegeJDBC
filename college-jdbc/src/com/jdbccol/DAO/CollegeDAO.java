package com.jdbccol.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollegeDAO {

	public void saveCollege() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "xworkz");
			stmt = con.createStatement();
			stmt.executeUpdate("insert into college_table values(1,'DR.AIT',200,6,7)");
			stmt.executeUpdate("insert into college_table values(2,'RNSIT',500,15,8)");
			stmt.executeUpdate("insert into college_table values(3,'SJBIT',100,4,5)");
			stmt.executeUpdate("insert into college_table values(4,'DON BOSCO',300,3,1)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void updateCollege(int id, String cName) {
		Connection con = null;
		Statement stmt = null;
		int rowAffected = 0;
		int id1 = id;
		String name = cName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "xworkz");
			System.out.println("Updating college name by college id");
			stmt = con.createStatement();
			stmt.executeUpdate("update college_table set cname=" + "'" + name + "'" + " where id=" + id);
			System.out.println("Number of row affected " + rowAffected);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void readCollege() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "xworkz");
			stmt = con.createStatement();
			System.out.println("Printing all values from data base.....");
			ResultSet rs = stmt.executeQuery("select * from college_table");
			while (rs.next()) {
				System.out.println("college id is " + rs.getInt(1));
				System.out.println("college name is " + rs.getString(2));
				System.out.println("no of students is " + rs.getInt(3));
				System.out.println("subjects offered is " + rs.getInt(4));
				System.out.println("courses  " + rs.getInt(5));
				System.out.println("=========================");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteCollege(int id) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "xworkz");
			stmt = con.createStatement();
			stmt.executeUpdate("delete from college_table where id= " + id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
