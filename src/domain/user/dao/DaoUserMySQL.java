package domain.user.dao;

import java.util.ArrayList;

import config.MySQLConfig;
import domain.user.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUserMySQL implements DaoUser {

	public DaoUserMySQL() {}

	@Override
	public User loadUser(String username, String password) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		User user = null;
		ResultSet rs = null;
		
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE username='"+username+"' "
				+ "AND password='"+password+"';";
		
		try{
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		
		MySQLConfig.disconnect(connection,stm);
		return user;
	}

	@Override
	public User loadUser(int userId) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		User user = null;
		ResultSet rs = null;
		
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE userId="+userId;
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		
		MySQLConfig.disconnect(connection,stm);
		return user;
	}

	@Override
	public ArrayList<User> loadUsers() {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		ResultSet rs = null;
		
		String sqlQuery = "SELECT * FROM user";
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
				
				users.add(user);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoUserMySQL loadUsers select");
		}
		
		MySQLConfig.disconnect(connection,stm);
		return users;
	}

	@Override
	public boolean insertUser(User user) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "INSERT INTO user (username,password,first_name,second_name,email) "+
		"VALUES("
		+ "'"+user.getUsername()+"',"
		+ "'"+user.getPassword()+"',"
		+ "'"+user.getFirstName()+"',"
		+ "'"+user.getSecondName()+"',"
		+ "'"+user.getEmail()+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
	}
	
	@Override
	public boolean updateUser(User user) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "UPDATE user "+
		"SET "
		+ "username='"+user.getUsername()+"',"
		+ "password='"+user.getPassword()+"',"
		+ "first_name='"+user.getFirstName()+"',"
		+ "second_name='"+user.getSecondName()+"',"
		+ "email='"+user.getEmail()+"'"
		+ "WHERE userId="+user.getUserId();
		System.out.println(sqlQuery);

		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
		
	}


	@Override
	public boolean deleteUser(int userId) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "DELETE FROM user WHERE userId="+userId;
		System.out.println(sqlQuery);

		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
	}

}
