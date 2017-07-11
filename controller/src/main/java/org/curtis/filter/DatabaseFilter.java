package org.curtis.filter;

import org.curtis.database.DBSessionFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DatabaseFilter extends BaseFilter {
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
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
