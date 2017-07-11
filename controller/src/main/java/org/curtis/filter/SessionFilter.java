package org.curtis.filter;

import org.curtis.session.SessionException;
import org.curtis.session.SessionHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter extends BaseFilter {
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            SessionHandler.getInstance().getSession(request, response);
        } catch (SessionException e) {
            System.err.println("ERROR INITIALIZING SESSION: " + e.getMessage());
            throw new ServletException(e.getMessage());
        }

        chain.doFilter(request, response);
    }
}
