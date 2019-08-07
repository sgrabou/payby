package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {
    private Long orderID;
    private Date creationDate;
    private BigDecimal amount;
    private String orderDetails;
    private OrderStatus orderStatus;
    private MerchandDTO merchand;
    private CustomerDTO customer;
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

    public MerchandDTO getMerchand() {
        return merchand;
    }

    public void setMerchand(MerchandDTO merchand) {
        this.merchand = merchand;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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
