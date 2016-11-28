package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.servlet.mvc.controllers.AddProductController;
import lv.javaguru.java2.servlet.mvc.controllers.ViewProductController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<>();
        controllers.put("/", new ViewProductController());
        controllers.put("/addProduct", new AddProductController());
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();
        //String method = req.getMethod();

        if (contextURI.contains("/css")) {
            filterChain.doFilter(request, response);
        } else {
            MVCController controller = controllers.get(contextURI);
            MVCModel model = processRequestByMethodAndReturnModel(req, controller);

            req.setAttribute("data", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
        }

    }

    private MVCModel processRequestByMethodAndReturnModel(HttpServletRequest req, MVCController controller ) {
        String method = req.getMethod();
        return method.equalsIgnoreCase("GET") ? controller.processGet(req) : controller.processPost(req);
    }

    @Override
    public void destroy() {}

}
