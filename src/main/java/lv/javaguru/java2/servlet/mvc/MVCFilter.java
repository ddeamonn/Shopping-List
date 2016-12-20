package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.servlet.mvc.controllers.AddProductController;
import lv.javaguru.java2.servlet.mvc.controllers.AddShoplistController;
import lv.javaguru.java2.servlet.mvc.controllers.ShoplistController;
import lv.javaguru.java2.servlet.mvc.controllers.ViewProductController;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    Logger logger = Logger.getLogger(MVCFilter.class);

    private Map<String, MVCController> controllers;

    private ApplicationContext springContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            System.out.println("error"+e.getMessage());
            logger.error("Error " + e.getMessage());
        }

        controllers = new HashMap<>();
        controllers.put("/", getBean(ShoplistController.class));
        controllers.put("/viewProduct", getBean(ViewProductController.class));
        controllers.put("/addProduct", getBean(AddProductController.class));
        controllers.put("/addShoplist", getBean(AddShoplistController.class));
    }

    private MVCController getBean ( Class<?> clazz ) {
        System.out.println("context:"+springContext);
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();

        if (controllers.containsKey(contextURI)) {
            MVCController controller = controllers.get(contextURI);
            MVCModel model = processRequestByMethodAndReturnModel(req, controller);

            req.setAttribute("data", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private MVCModel processRequestByMethodAndReturnModel(HttpServletRequest req, MVCController controller ) {
        String method = req.getMethod();
        return method.equalsIgnoreCase("GET") ? controller.processGet(req) : controller.processPost(req);
    }

    @Override
    public void destroy() {}

}
