package ma.payby.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ma.payby.common.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

public class ConfirmPaymentMerchantRequestDTO {

    @JsonProperty("RESPONSE_CODE")
    private String code;
    @JsonProperty("RESPONSE_MESSAGE")
    private String message;
    @JsonProperty("PAYBY_MESSAGE_VERSION")
    private String paybyVersion;
    @JsonProperty("MERCHANT_ID")
    private String merchantUserName;
    @JsonProperty("REFERENCE_ID")
    private String reference;
    @JsonProperty("TRANSACTION_DATE")
    private Date transactionDate;
    @JsonProperty("ORDER_ID")
    private String orderID;
    @JsonProperty("AMOUNT")
    private BigDecimal amount;
    @JsonProperty("TRANSACTION_STATE")
    private OrderStatus status;
    @JsonProperty("MESSAGE_SIGNATURE")
    private String signature;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPaybyVersion() {
        return paybyVersion;
    }

    public void setPaybyVersion(String paybyVersion) {
        this.paybyVersion = paybyVersion;
    }

    public String getMerchantUserName() {
        return merchantUserName;
    }

    public void setMerchantUserName(String merchantUserName) {
        this.merchantUserName = merchantUserName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
