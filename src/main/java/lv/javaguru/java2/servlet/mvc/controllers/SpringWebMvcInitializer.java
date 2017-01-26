package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Created by Amir on 26.01.2017..
 */
public class SpringWebMvcInitializer extends AbstractDispatcherServletInitializer {

        @Override
        protected WebApplicationContext createRootApplicationContext() {
            AnnotationConfigWebApplicationContext applicationContext =
                    new AnnotationConfigWebApplicationContext();
            applicationContext.register(SpringConfig.class);
            return applicationContext;
        }
        @Override
        protected WebApplicationContext createServletApplicationContext() {
            AnnotationConfigWebApplicationContext applicationContext =
                    new AnnotationConfigWebApplicationContext();
            applicationContext.register(WebMVCConfig.class);
            return applicationContext;
        }
        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
    }
