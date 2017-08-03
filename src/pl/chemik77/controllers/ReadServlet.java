package pl.chemik77.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.chemik77.utils.ServletUtil;
import pl.chemik77.utils.queries.ReadQuery;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			ReadQuery readQuery = new ReadQuery();
			readQuery.doRead();
			String table = readQuery.getHTMLTable();
			request.setAttribute("table", table);
			String url = "/read.jsp";

			ServletUtil.forwardRequest(url, request, response);
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}

}
