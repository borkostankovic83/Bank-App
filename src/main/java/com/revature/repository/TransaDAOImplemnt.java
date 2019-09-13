package com.revature.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.model.Transaction;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.StreamCloser;

public class TransaDAOImplemnt implements TransDAO {

	@Override
	public Transaction getTansaction(int id) {
		
		Transaction transaction = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM transactions WHERE id = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setLong(1, id);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							transaction = createTransactionFromRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}
	@Override
	public boolean createTeansaction(Transaction t) {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO transactions VALUES (DEFAULT, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, t.id);
			stmt.setString(2, t.transactions);
			stmt.setInt(3, t.users_id);		
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
	public boolean updateTeansaction(Transaction t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return true;
	}
	private Transaction createTransactionFromRS(ResultSet resultSet) throws SQLException {
		return new Transaction(
				resultSet.getInt("id"),
				resultSet.getString("transactions"),
				resultSet.getInt("user_id"));
	}

}
