package pl.chemik77.utils.queries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import pl.chemik77.model.Address;
import pl.chemik77.model.Customer;
import pl.chemik77.utils.DbManager;

public class AddQuery {

	private Connection connection;

	public AddQuery() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		this.connection = DbManager.getConnection();
	}

	public void doAdd(Customer customer, Address address) throws SQLException {

		String sql1 = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql1);
		preparedStatement.setInt(1, customer.getStore_id());
		preparedStatement.setString(2, customer.getFirstName());
		preparedStatement.setString(3, customer.getLastName());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.setInt(5, customer.getAddress_id());
		preparedStatement.setInt(6, customer.getActive());
		Date date = new Date(System.currentTimeMillis());
		preparedStatement.setDate(7, date);
		preparedStatement.setTimestamp(8, new Timestamp(date.getTime()));

		preparedStatement.executeUpdate();

		String sql2 = "INSERT INTO address (street, house_no, postal_code, city, country) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		preparedStatement2.setString(1, address.getStreet());
		preparedStatement2.setString(2, address.getHouseNo());
		preparedStatement2.setString(3, address.getPostalCode());
		preparedStatement2.setString(4, address.getCity());
		preparedStatement2.setString(5, address.getCountry());

		preparedStatement2.executeUpdate();

	}

	public int getLastRowAddress() throws SQLException {
		int lastId = 0;
		String sql = "SELECT * FROM address WHERE address_id=(SELECT MAX(address_id) FROM address)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		lastId = resultSet.getInt("address_id");

		return lastId;
	}
}
