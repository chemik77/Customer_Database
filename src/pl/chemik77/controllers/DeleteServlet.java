package pl.chemik77.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.chemik77.utils.ServletUtil;
import pl.chemik77.utils.queries.DeleteQuery;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int customer_id = Integer.parseInt(request.getParameter("customer_id"));
			
			DeleteQuery deleteQuery = new DeleteQuery();
			deleteQuery.doDelete(customer_id);
			
			String url = "/read";
			ServletUtil.forwardRequest(url, request, response);
		} catch (NumberFormatException | ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
