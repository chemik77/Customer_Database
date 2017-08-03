package pl.chemik77.utils.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import pl.chemik77.model.Address;
import pl.chemik77.model.Customer;
import pl.chemik77.utils.DbManager;

public class UpdateQuery {

	private Connection connection;

	public UpdateQuery() {
		this.connection = DbManager.getConnection();
	}

	public int doUpdate(Customer customer, Address address) throws SQLException {
		int result = 0;
		String sql1 = "UPDATE customer SET store_id=?, first_name=?, last_name=?, email=?, active=?, last_update=? WHERE customer_id=?";
		String sql2 = "UPDATE address SET street=?, house_no=?, postal_code=?, city=?, country=? WHERE address_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql1);

		preparedStatement.setInt(1, customer.getStore_id());
		preparedStatement.setString(2, customer.getFirstName());
		preparedStatement.setString(3, customer.getLastName());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.setInt(5, customer.getActive());
		preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(7, customer.getCustomer_id());

		result = preparedStatement.executeUpdate();

		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

		preparedStatement2.setString(1, address.getStreet());
		preparedStatement2.setString(2, address.getHouseNo());
		preparedStatement2.setString(3, address.getPostalCode());
		preparedStatement2.setString(4, address.getCity());
		preparedStatement2.setString(5, address.getCountry());
		preparedStatement2.setInt(6, address.getAddress_id());

		preparedStatement2.executeUpdate();

		return result;
	}

}
