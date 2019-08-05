package ma.payby.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class InitierPaymentMerchandRequestDTO {

    @JsonProperty("ORDER_ID")
    private String orderID;
    @JsonProperty("ORDER_DETAILS")
    private String orderDetails;
    @JsonProperty("MERCHANT_ID")
    private String merchandUserName;
    @JsonProperty("AMOUNT")
    private BigDecimal amount;
    @JsonProperty("CUSTOMER_LASTNAME")
    private String customerLastName;
    @JsonProperty("CUSTOMER_FIRSTNAME")
    private String customerfirstName;
    @JsonProperty("CUSTOMER_ADDRESS")
    private String customerAdress;
    @JsonProperty("CUSTOMER_ZIPCODE")
    private String codePostal;
    @JsonProperty("CUSTOMER_CITY")
    private String ville;
    @JsonProperty("CUSTOMER_COUNTRY")
    private String pays;
    @JsonProperty("CUSTOMER_PHONE")
    private String phoneNumber;
    @JsonProperty("CUSTOMER_EMAIL")
    private String email;
    @JsonProperty("MESSAGE_SIGNATURE")
    private String signature;
    @JsonProperty("CUSTOMER_MESSAGE")
    private String customerMessage;
    @JsonProperty("MERCHANT_URL")
    private String getMerchandUrl;


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getMerchandUserName() {
        return merchandUserName;
    }

    public void setMerchandUserName(String merchandUserName) {
        this.merchandUserName = merchandUserName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerfirstName() {
        return customerfirstName;
    }

    public void setCustomerfirstName(String customerfirstName) {
        this.customerfirstName = customerfirstName;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public String getGetMerchandUrl() {
        return getMerchandUrl;
    }

    public void setGetMerchandUrl(String getMerchandUrl) {
        this.getMerchandUrl = getMerchandUrl;
    }
}
