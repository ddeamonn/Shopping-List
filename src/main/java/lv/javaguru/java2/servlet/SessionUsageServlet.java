package lv.javaguru.java2.servlet;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionUsageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp) throws ServletException, IOException {

		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getById(1L);

		// Set response content type
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		Long counter = (Long)session.getAttribute("key");
		if(counter == null) {
			counter = 0L;
		}
		counter++;
		session.setAttribute("key", counter);

		// Actual logic goes here.
		PrintWriter out = resp.getWriter();
		out.println("<h1>" + "Hello World from Java!" + "</h1>");
		out.println("Counter = " + session.getAttribute("key"));
	}

}
