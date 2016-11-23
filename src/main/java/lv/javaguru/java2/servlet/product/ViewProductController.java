package lv.javaguru.java2.servlet.product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.jdbc.ProductDAOImpl;
import lv.javaguru.java2.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by DMC on 11/22/2016.
 */

//@WebServlet(name = "ViewProductController")
public class ViewProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> products = productDAO.getAll();

        request.setAttribute("products", products);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/startpage.jsp");
        requestDispatcher.forward(request, response);
    }
}
