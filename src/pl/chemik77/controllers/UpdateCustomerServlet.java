package pl.chemik77.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.chemik77.model.Address;
import pl.chemik77.model.Customer;
import pl.chemik77.utils.ServletUtil;
import pl.chemik77.utils.queries.UpdateQuery;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			int customer_id = Integer.parseInt(request.getParameter("customer_id"));
			int store_id = Integer.parseInt(request.getParameter("store_id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			int active = Integer.parseInt(request.getParameter("active"));

			Customer customer = new Customer();
			customer.setCustomer_id(customer_id);
			customer.setStore_id(store_id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setActive(active);

			int address_id = Integer.parseInt(request.getParameter("address_id"));
			String street = request.getParameter("street");
			String houseNo = request.getParameter("houseNo");
			String postalCode = request.getParameter("postalCode");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			Address address = new Address();
			address.setAddress_id(address_id);
			address.setStreet(street);
			address.setHouseNo(houseNo);
			address.setPostalCode(postalCode);
			address.setCity(city);
			address.setCountry(country);

			UpdateQuery updateQuery = new UpdateQuery();
			updateQuery.doUpdate(customer, address);

			String url = "/read";
			ServletUtil.forwardRequest(url, request, response);
		} catch (NumberFormatException | ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}

}
