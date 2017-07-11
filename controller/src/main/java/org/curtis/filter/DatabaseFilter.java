package org.curtis.filter;

import org.curtis.database.DBSessionFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DatabaseFilter implements Filter {

    public void init(FilterConfig config) {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } finally {
            commitDBTransaction();
            closeDBTransaction();
        }
    }

    private void commitDBTransaction() {
        try {
            DBSessionFactory.getInstance().commitTransaction();
        } catch (Exception e) {
            System.err.println("ERROR COMMITTING DB TRANSACTION: " + e.getMessage());
        }
    }

    private void closeDBTransaction() {
        try {
            DBSessionFactory.getInstance().closeTransaction();
        } catch (Exception e) {
            System.err.println("ERROR CLOSING DB TRANSACTION: " + e.getMessage());
        }
    }
}
