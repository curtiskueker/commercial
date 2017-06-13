package org.curtis.order;

import org.curtis.access.AccessUser;
import org.curtis.database.DatedDatabaseItem;
import org.curtis.item.Item;
import org.curtis.payment.GiftCard;
import org.curtis.payment.OrderPayment;
import org.curtis.tracking.Tracking;
import org.curtis.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends DatedDatabaseItem {
    @Column(name = "external_id")
    private String externalId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "access_user_id")
    private AccessUser accessUser;

    @OneToOne
    @JoinColumn(name = "tracking_id")
    private Tracking tracking;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<GiftCard> giftCards = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<OrderStatus> orderStatuses = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<OrderAdjustment> orderAdjustments = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<OrderPayment> orderPayments = new ArrayList<>();

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<GiftCard> getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(List<GiftCard> giftCards) {
        this.giftCards = giftCards;
    }

    public List<OrderStatus> getOrderStatuses() {
        return orderStatuses;
    }

    public void setOrderStatuses(List<OrderStatus> orderStatuses) {
        this.orderStatuses = orderStatuses;
    }

    public List<OrderAdjustment> getOrderAdjustments() {
        return orderAdjustments;
    }

    public void setOrderAdjustments(List<OrderAdjustment> orderAdjustments) {
        this.orderAdjustments = orderAdjustments;
    }

    public List<OrderPayment> getOrderPayments() {
        return orderPayments;
    }

    public void setOrderPayments(List<OrderPayment> orderPayments) {
        this.orderPayments = orderPayments;
    }
}
