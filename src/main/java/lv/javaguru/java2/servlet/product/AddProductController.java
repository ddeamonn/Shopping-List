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
//@WebServlet(name = "AddProductController")
public class AddProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("pname");

        Product product = new Product();
        product.setProductName(productName);

        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.create(product);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/addProductResult.jsp");
        requestDispatcher.forward(request, response);
    }

}
