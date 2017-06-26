package org.curtis.filter;

import org.curtis.properties.AppProperties;
import org.curtis.properties.PropertyFileNotFoundException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AppFilter implements Filter {
    private static boolean appPropertiesLoaded = false;

    public void init(FilterConfig config) {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if(!appPropertiesLoaded) {
            try {
                AppProperties.addPropertiesFile("app");
                appPropertiesLoaded = true;
            } catch (PropertyFileNotFoundException e) {
                throw new ServletException("app properties file not found");
            }
        }

        chain.doFilter(request, response);
    }
}
