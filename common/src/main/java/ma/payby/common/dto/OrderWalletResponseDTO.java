package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;

import java.math.BigDecimal;

public class OrderWalletResponseDTO {
    private String merchandNumber;
    private String merchandName;
    private String websiteUrl;
    private OrderStatus orderStatus;
    private BigDecimal amount;
    private String orderDetails;

      public String getMerchandNumber() {
        return merchandNumber;
    }

    public void setMerchandNumber(String merchandNumber) {
        this.merchandNumber = merchandNumber;
    }

    public String getMerchandName() {
        return merchandName;
    }

    public void setMerchandName(String merchandName) {
        this.merchandName = merchandName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
}
