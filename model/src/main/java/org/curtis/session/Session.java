package org.curtis.session;

import org.curtis.access.AccessUser;
import org.curtis.database.DatedDatabaseItem;
import org.curtis.order.Order;
import org.curtis.tracking.Tracking;
import org.curtis.user.User;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session extends DatedDatabaseItem {
    @Column(name = "cookie")
    private String cookie;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "access_user_id")
    private AccessUser accessUser;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "tracking_id")
    private Tracking tracking;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessUser getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(AccessUser accessUser) {
        this.accessUser = accessUser;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }
}
