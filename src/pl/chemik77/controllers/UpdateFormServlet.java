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
import pl.chemik77.utils.queries.ReadRecord;

@WebServlet("/update")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			int customer_id = Integer.parseInt(request.getParameter("customer_id"));

			ReadRecord readRecord = new ReadRecord(customer_id);
			readRecord.doRead();
			Customer customer = readRecord.getCustomer();
			Address address = readRecord.getAddress();
			request.setAttribute("customer", customer);
			request.setAttribute("address", address);

			String url = "/updateForm.jsp";
			ServletUtil.forwardRequest(url, request, response);
		} catch (NumberFormatException | SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
