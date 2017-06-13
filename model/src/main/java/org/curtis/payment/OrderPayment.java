package org.curtis.payment;

import org.curtis.database.DatedDatabaseItem;
import org.curtis.order.Order;
import org.curtis.payment.CreditCard;
import org.curtis.payment.GiftCard;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_payment")
public class OrderPayment extends DatedDatabaseItem {
    @Column(name = "payment_type")
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "gift_card_id")
    private GiftCard giftCard;

    @Column(name = "amount")
    private BigDecimal amount;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public GiftCard getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(GiftCard giftCard) {
        this.giftCard = giftCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
