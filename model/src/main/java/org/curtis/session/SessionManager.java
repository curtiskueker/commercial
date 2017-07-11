package org.curtis.session;

import org.curtis.database.DBException;
import org.curtis.database.DBSessionFactory;
import org.curtis.database.DatabaseItemManager;

public class SessionManager {
    private static SessionManager instance;

    private SessionManager() {
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    public Session getSession(String cookieID) throws SessionException {
        if (cookieID == null) {
            throw new IllegalArgumentException("getSession: Cookie ID is null");
        }

        try {
            return DatabaseItemManager.getInstance().find(Session.class, "cookie", cookieID);
        } catch (Exception e) {
            throw new SessionException(e);
        }
    }

    public Session newSession(String cookieID) throws SessionException {
        Session session = new Session();

        session.setCookie(cookieID);

        try {
            DBSessionFactory.getInstance().getTransaction().create(session);
        } catch (DBException e) {
            throw new SessionException(e);
        }

        return session;
    }
}
