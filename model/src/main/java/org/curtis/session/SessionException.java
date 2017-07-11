package org.curtis.session;

import org.curtis.exception.BaseException;

public class SessionException extends BaseException {
    public SessionException(String msg) {
        super(msg);
    }

    public SessionException(Exception e) {
        super(e);
    }
}
