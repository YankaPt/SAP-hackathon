package by.bsu.hachaton.config.initializer;

import by.bsu.hachaton.config.AppConfig;
import by.bsu.hachaton.config.SecurityConfig;
import by.bsu.hachaton.config.WebConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class, AppConfig.class, SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[] {};
//    }
}
