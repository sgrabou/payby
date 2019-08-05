package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;

import java.util.Date;

public class PaiementDTO {
    private Long paiementID;
    private OrderDTO order;
    private OrderStatus orderStatus;
    private Date dateStatus;
    private WalletDTO wallet;

    public Long getPaiementID() {
        return paiementID;
    }

    public void setPaiementID(Long paiementID) {
        this.paiementID = paiementID;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(Date dateStatus) {
        this.dateStatus = dateStatus;
    }

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
    }
}
