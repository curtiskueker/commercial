package org.curtis.payment;

import org.curtis.database.DatedDatabaseItem;
import org.curtis.order.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "gift_card")
public class GiftCard extends DatedDatabaseItem {
    @Column(name = "claimcode")
    private String claimcode;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinTable(name = "order_gift_card", joinColumns = @JoinColumn(name = "gift_card_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Order order;

    public String getClaimcode() {
        return claimcode;
    }

    public void setClaimcode(String claimcode) {
        this.claimcode = claimcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
