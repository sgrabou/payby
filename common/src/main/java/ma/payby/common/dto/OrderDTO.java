package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;
import ma.payby.common.utils.NumberUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

public class OrderDTO {
    private Long orderID;
    private Date creationDate;
    private BigDecimal amount;
    private String orderDetails;
    private OrderStatus orderStatus;
    private MerchantDTO merchant;
    private CustomerDTO customer;
    private String reference;
    private String merchantOrderID;
    private String displayedAmount;

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

    public MerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        this.merchant = merchant;
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

    public String getMerchantOrderID() {
        return merchantOrderID;
    }

    public void setMerchantOrderID(String merchantOrderID) {
        this.merchantOrderID = merchantOrderID;
    }

    public String getDisplayedAmount() {
        return NumberUtils.formatNumber(this.amount);
    }
}
