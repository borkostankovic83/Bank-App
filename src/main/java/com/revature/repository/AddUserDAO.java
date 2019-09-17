package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.StreamCloser;

public class AddUserDAO implements UserDAO {
	/**
	 * Returns user found by id, or null if no user found
	 */

	@Override
	public User getUser(int id) {
		User user = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM users WHERE id = ?;";
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setInt(1, id);
				if(stmt.execute()) {
					try(ResultSet resultSet =stmt.getResultSet()){
						if(resultSet.next()	) {
							user = createUserFromRS(resultSet);
						}
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * Return a user found via their username, or null if no user is found
	 * 
	 * 
	 */

	@Override
	public User getUser(String username) {
		ResultSet resultSet = null;
		//PreparedStatements are better than simple ones
		PreparedStatement statement =  null;
		User user = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM users WHERE username = ?;");
		
			//fill in the ? with name argument
			statement.setString(1, username);
			
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					user = createUserFromRS(resultSet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		
		return user;
	}
	/**
	 * Return a user found via their username, or null if no user is found
	 * And checks for password
	 * 
	 */

	@Override
	public User getUser(String username, String password) {
		ResultSet resultSet = null;
		PreparedStatement statement =  null;
		User user = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM users WHERE username = ?AND password = ?;");
		
			//fill in the ? with name argument
			statement.setString(1, username);
			statement.setString(2, password);
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					user = createUserFromRS(resultSet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		
		return user;
	}
	/**
	 * Returns a list of all users in the users table
	 * 
	 * 
	 */

	@Override
	public List<User> getUser() {
		// Statement and ResultSet (and Connection) interfaces
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		// List to return
		List<User> user = new ArrayList<User>();
		try {
			// get connection from ConnectionUtil:
			conn = ConnectionUtil.getConnection();

			// create statement from connection
			statement = conn.createStatement();

			// Statements can execute sql queries:
			// ResultSet stores the results of a query
			resultSet = statement.executeQuery("SELECT * FROM users;");

			// loop through ResultSet
			while (resultSet.next()) {
				// At each row in the ResultSet, do the following:
				user.add(createUserFromRS(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close all open resources to prevent memory leak
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
			StreamCloser.close(conn);
		}

		return user;
	}
	/*
	 *  Here it insert all data to create new user
	 *  and insert in user table into database
	 */
	@Override
	public boolean createUser(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO users VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUserName());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getAccountType());
			stmt.setDouble(6, u.getBalance());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}

	@Override
	public boolean updateUser(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String query = "UPDATE users SET firstname=?, lastname=?, username=?," + 
		" password=?, account=?, balance=ROUND(CAST(? AS NUMERIC), 2) WHERE id = ?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);			
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUserName());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getAccountType());
			stmt.setDouble(6, u.getBalance());
			
			stmt.setLong(7, u.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}


	@Override
	public boolean deleteUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	private User createUserFromRS(ResultSet resultSet) throws SQLException {
		return new User(
				resultSet.getInt("id"),
				resultSet.getString("firstName"),
				resultSet.getString("lastName"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getString("account"),
				resultSet.getFloat("balance"));
			
	}
}
