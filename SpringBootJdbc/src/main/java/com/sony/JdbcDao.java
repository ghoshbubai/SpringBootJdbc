package com.sony;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDao 
{
	@Autowired
	private DataSource datasource;

	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public Employee getEmp(String string) {
		Employee e1=new Employee();
		
		try {
			Connection con=datasource.getConnection();
			PreparedStatement  pst=con.prepareStatement("select * from employee where ename=?");
			pst.setString(1, string);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				e1.setEname(rs.getString(1));
				e1.setEpoints(rs.getInt(2));
			}
			System.out.println(datasource.getClass().getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return e1;
	}
	public void createEmp(Employee e1) {
		
		Connection con;
		try {
			con = datasource.getConnection();
			PreparedStatement  pst=con.prepareStatement("insert into employee values(?,?)");
			pst.setString(1, e1.getEname());
			pst.setInt(2, e1.getEpoints());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
