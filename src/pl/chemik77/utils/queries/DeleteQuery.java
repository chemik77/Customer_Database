package pl.chemik77.utils.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.chemik77.model.Customer;
import pl.chemik77.utils.DbManager;

public class DeleteQuery {

	private Connection connection;

	public DeleteQuery() {
		this.connection = DbManager.getConnection();
	}

	public void doDelete(int customer_id) throws SQLException {

		ReadRecord readRecord = new ReadRecord(customer_id);
		readRecord.doRead();
		Customer customer = readRecord.getCustomer();
		delete("customer", customer_id);
		delete("address", customer.getAddress_id());

	}

	private int delete(String table_name, int id) throws SQLException {

		int result = 0;
		String sql = "DELETE FROM " + table_name + " WHERE " + table_name + "_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		result = preparedStatement.executeUpdate();
		return result;

	}

}
