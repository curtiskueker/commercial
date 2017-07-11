package org.curtis.filter;

import org.curtis.properties.AppProperties;
import org.curtis.properties.PropertyFileNotFoundException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppFilter extends BaseFilter {
    private static boolean appPropertiesLoaded = false;

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
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
