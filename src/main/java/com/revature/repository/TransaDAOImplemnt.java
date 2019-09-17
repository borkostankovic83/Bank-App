package com.revature.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Transaction;
import com.revature.service.UsernameAndPassword;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.StreamCloser;

public class TransaDAOImplemnt implements TransDAO {
	/**
	 * 
	 */
	@Override
	public Transaction getTransaction(int users_id) {
		
		Transaction t = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query ="SELECT * FROM transactions WHERE users_id = ?;";			
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setLong(1, users_id);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							t = createTransactionFromRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean createTransaction(Transaction t) {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO transactions VALUES (DEFAULT, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, t.transactions);
			stmt.setInt(2, t.users_id);		
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
	/**
	 * Returns a list of all users in the users table
	 * 
	 * 
	 */

	@Override
	public List<Transaction> getTransaction() {
		// Statement and ResultSet (and Connection) interfaces
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		// List to return
		List<Transaction> transaction = new ArrayList<Transaction>();
		try {
			// get connection from ConnectionUtil:
			conn = ConnectionUtil.getConnection();

			// create statement from connection
			statement = conn.createStatement();

			// Statements can execute sql queries:
			// ResultSet stores the results of a query
			
			resultSet = statement.executeQuery("SELECT * FROM transactions WHERE users_id = "+UsernameAndPassword.currentUser.id+";");

			// loop through ResultSet
			while (resultSet.next()) {
				// At each row in the ResultSet, do the following:
				transaction.add(createTransactionFromRS(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close all open resources to prevent memory leak
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
			StreamCloser.close(conn);
		}

		return transaction;
	}
	/**
	 * 
	 */
	@Override
	public boolean updateTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 */
	@Override
	public boolean deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private Transaction createTransactionFromRS(ResultSet resultSet) throws SQLException {
		return new Transaction(
				resultSet.getInt("id"),
				resultSet.getString("transactions"),
				resultSet.getInt("users_id"),
				resultSet.getTimestamp("last_updated"));
				
	}

}