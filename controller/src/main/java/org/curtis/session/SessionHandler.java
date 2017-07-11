package org.curtis.session;

import org.curtis.util.UuidGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class SessionHandler {
    private static SessionHandler instance;

    private static final String SESSION_ATTRIBUTE_NAME = "userSession";
    private static final String SESSION_COOKIE_NAME = "JSESSIONID";

    private SessionHandler() {

    }

    public static synchronized SessionHandler getInstance() {
        if (instance == null) {
            instance = new SessionHandler();
        }

        return instance;
    }

    public Session getSession(HttpServletRequest request, HttpServletResponse response)
            throws SessionException {
        Session session = (Session) request.getAttribute(SESSION_ATTRIBUTE_NAME);

        if (session == null) {
            session = handleSession(request, response);
        }

        return session;
    }

    private Session handleSession(HttpServletRequest request, HttpServletResponse response)
            throws SessionException {
        String cookieID = getCookieID(request);

        if (cookieID.equals("")) {
            cookieID = setNewCookie(request, response);
        }

        Session session = SessionManager.getInstance().getSession(cookieID);

        if (session == null) {
            session = SessionManager.getInstance().newSession(cookieID);
        }

        session.setDateModified(Calendar.getInstance().getTime());

        setSessionInRequest(request, session);

        return session;
    }

    public void setSessionInRequest(HttpServletRequest request, Session session) {
        request.setAttribute(SESSION_ATTRIBUTE_NAME, session);
    }

    private String getCookieID(HttpServletRequest request) {
        String cookieID = "";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_COOKIE_NAME)) {
                    cookieID = cookie.getValue();
                    break;
                }
            }
        }

        return cookieID;
    }

    private String setNewCookie(HttpServletRequest request, HttpServletResponse response) {
        String cookieID = UuidGenerator.newUuid();

        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, cookieID);
        cookie.setPath("/");
        cookie.setMaxAge(47304000);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);

        return cookieID;
    }
}