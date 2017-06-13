package org.curtis.order;

import org.curtis.database.DatedDatabaseItem;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus extends DatedDatabaseItem {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status")
    private String status;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
