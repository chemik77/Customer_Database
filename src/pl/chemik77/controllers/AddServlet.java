package pl.chemik77.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.chemik77.model.Address;
import pl.chemik77.model.Customer;
import pl.chemik77.utils.ServletUtil;
import pl.chemik77.utils.queries.AddQuery;

@WebServlet("/addCustomer")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			AddQuery addQuery = new AddQuery();

			int store_id = Integer.parseInt(request.getParameter("store_id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			int active = Integer.parseInt(request.getParameter("active"));
			LocalDate createDate = LocalDate.now();
			LocalDateTime lastUpdate = LocalDateTime.now();

			Customer customer = new Customer();
			customer.setStore_id(store_id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			int address_id = addQuery.getLastRowAddress() + 1;
			customer.setAddress_id(address_id);
			customer.setActive(active);
			customer.setCreateDate(createDate);
			customer.setLastUpdate(lastUpdate);

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

			addQuery.doAdd(customer, address);

			String url = "/read";
			ServletUtil.forwardRequest(url, request, response);
		} catch (NumberFormatException | ServletException | IOException | SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
