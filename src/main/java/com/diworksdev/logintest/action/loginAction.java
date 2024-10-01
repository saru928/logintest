package com.diworksdev.logintest.action;
import java.sql.SQLException;

import com.diworksdev.logintest.dao.loginDAO;
import com.diworksdev.logintest.dto.loginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport{

	private String name;
	private String password;
	
	public String execute() throws SQLException{
		String ret = ERROR;
		
		loginDAO dao = new loginDAO();
		loginDTO dto = new loginDTO();
		
		dto = dao.select(name, password);
		
		if(name.equals(dto.getName())) {
			if(password.equals(dto.getPassword())) {
				ret = SUCCESS;
			}
		}
		return ret;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
