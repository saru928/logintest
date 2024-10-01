package com.diworksdev.logintest.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.logintest.dto.loginDTO;
import com.diworksdev.logintest.util.DBConnector;

public class loginDAO {

	public loginDTO select(String name, String password) throws SQLException{
		loginDTO dto = new loginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql = "select * from user where user_name=? and password=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return dto;
	}
}
