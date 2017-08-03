package pl.chemik77.utils.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.chemik77.model.Address;
import pl.chemik77.model.Customer;
import pl.chemik77.utils.DbManager;

public class ReadRecord {

	private Connection connection;
	private ResultSet result_customer;
	private ResultSet result_address;
	private Customer customer;
	private Address address;
	private int customer_id;

	public ReadRecord(int customer_id) {
		this.customer_id = customer_id;
		this.connection = DbManager.getConnection();
	}

	public void doRead() throws SQLException {

		String sql = "SELECT * FROM customer WHERE customer_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, customer_id);
		result_customer = preparedStatement.executeQuery();
		result_customer.next();

		this.customer = new Customer();
		this.customer.setCustomer_id(result_customer.getInt("customer_id"));
		this.customer.setStore_id(result_customer.getInt("store_id"));
		this.customer.setFirstName(result_customer.getString("first_name"));
		this.customer.setLastName(result_customer.getString("last_name"));
		this.customer.setEmail(result_customer.getString("email"));
		this.customer.setAddress_id(result_customer.getInt("address_id"));
		this.customer.setActive(result_customer.getInt("active"));
		this.customer.setCreateDate(result_customer.getDate("create_date").toLocalDate());
		this.customer.setLastUpdate(result_customer.getTimestamp("last_update").toLocalDateTime());

		String sql2 = "SELECT * FROM address WHERE address_id=?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		preparedStatement2.setInt(1, customer.getAddress_id());
		result_address = preparedStatement2.executeQuery();
		result_address.next();

		this.address = new Address();
		this.address.setAddress_id(result_address.getInt("address_id"));
		this.address.setStreet(result_address.getString("street"));
		this.address.setHouseNo(result_address.getString("house_no"));
		this.address.setPostalCode(result_address.getString("postal_code"));
		this.address.setCity(result_address.getString("city"));
		this.address.setCountry(result_address.getString("country"));

	}

	public Customer getCustomer() {
		return this.customer;
	}

	public Address getAddress() {
		return this.address;
	}

}
