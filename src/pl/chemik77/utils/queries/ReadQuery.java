package pl.chemik77.utils.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.chemik77.model.Customer;
import pl.chemik77.utils.DbManager;

public class ReadQuery {

	private Connection connection;
	private ResultSet resultSet;

	public ReadQuery() {
		this.connection = DbManager.getConnection();
	}

	public void doRead() throws SQLException {
		String sql = "SELECT customer_id, first_name, last_name, email, active FROM customer";

		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		this.resultSet = preparedStatement.executeQuery();

	}

	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table border=1>";

		table += "<thead>";
		table += "<tr>";
		table += "<td>";
		table += "Last name";
		table += "</td>";
		table += "<td>";
		table += "First name";
		table += "</td>";
		table += "<td>";
		table += "Email";
		table += "</td>";
		table += "<td>";
		table += "Active";
		table += "</td>";
		table += "<td>";
		table += "Update";
		table += "</td>";
		table += "<td>";
		table += "Delete";
		table += "</td>";
		table += "</tr>";
		table += "</thead>";
		table += "<tbody>";

		while (this.resultSet.next()) {
			Customer customer = new Customer();
			customer.setCustomer_id(this.resultSet.getInt("customer_id"));
			customer.setFirstName(this.resultSet.getString("first_name"));
			customer.setLastName(this.resultSet.getString("last_name"));
			customer.setEmail(this.resultSet.getString("email"));
			customer.setActive(this.resultSet.getInt("active"));

			table += "<tr>";
			table += "<td>";
			table += customer.getLastName();
			table += "</td>";
			table += "<td>";
			table += customer.getFirstName();
			table += "</td>";
			table += "<td>";
			table += customer.getEmail();
			table += "</td>";
			table += "<td>";
			if (customer.getActive() == 1) {
				table += "YES";
			} else {
				table += "NO";
			}
			table += "</td>";

			table += "<td>";
			table += "<a href=update?customer_id=" + customer.getCustomer_id() + " class=\"button\" >update</a>";
			table += "</td>";
			table += "<td>";
			table += "<a href=delete?customer_id=" + customer.getCustomer_id() + " class=\"button\" >delete</a>";
			table += "</td>";

			table += "</tr>";
		}

		table += "</tbody>";
		table += "</table>";
		return table;
	}

}
