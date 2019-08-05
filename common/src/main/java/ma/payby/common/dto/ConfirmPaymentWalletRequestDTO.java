package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;

import java.util.Date;

public class ConfirmPaymentWalletRequestDTO {
    private String refernece;
    private String amount;
    private String marchadPhoneNumber;
    private OrderStatus orderStatus;
    private Date dateStatut;
    private String signature;

    public String getRefernece() {
        return refernece;
    }

    public void setRefernece(String refernece) {
        this.refernece = refernece;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMarchadPhoneNumber() {
        return marchadPhoneNumber;
    }

    public void setMarchadPhoneNumber(String marchadPhoneNumber) {
        this.marchadPhoneNumber = marchadPhoneNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDateStatut() {
        return dateStatut;
    }

    public void setDateStatut(Date dateStatut) {
        this.dateStatut = dateStatut;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
