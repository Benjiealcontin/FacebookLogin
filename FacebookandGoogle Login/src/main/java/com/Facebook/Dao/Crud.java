package com.Facebook.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Facebook.Model.Users;

public class Crud {

	private final static String url = "jdbc:mysql://localhost:3306/facebook";
	private final static String user = "root";
	private final static String password = "";
	private final static String dbloader = "com.mysql.jdbc.Driver";

	private final static String ADD = "INSERT INTO `lists`(`Name`, `Email`, `Location`, `Gender`, `Picture`, `Token`) "
			+ "VALUES (?,?,?,?,?,?)";

	public static void Driver(String dbloader) {
		try {
			Class.forName(dbloader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static int Adduser(Users user) {
		int i = 0;

		try {
			Driver(dbloader);
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(ADD);
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getLocation());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getProfile_picture());
			pst.setString(6, user.getToken());

			i = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

}
