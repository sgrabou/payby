package ma.payby.common.jpa.model;


import ma.payby.common.enums.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "paiement_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long orderID;
    private Date creationDate;
    private BigDecimal amount;
    private String orderDetails;
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "merchandID")
    private Merchand merchand;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customerID")
    private Customer customer;
    @Column(unique = true)
    private String reference;
    private String merchandOrderID;


    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Merchand getMerchand() {
        return merchand;
    }

    public void setMerchand(Merchand merchand) {
        this.merchand = merchand;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMerchandOrderID() {
        return merchandOrderID;
    }

    public void setMerchandOrderID(String merchandOrderID) {
        this.merchandOrderID = merchandOrderID;
    }
}