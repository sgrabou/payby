package ma.payby.common.jpa.model;

import ma.payby.common.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "paiement_wallet")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long paiementID;
    @OneToOne
    @JoinColumn(name = "orderID")
    private Order order;
    private OrderStatus orderStatus;
    private Date dateStatus;
    @ManyToOne
    @JoinColumn(name = "walletID")
    private Wallet wallet;

    public Long getPaiementID() {
        return paiementID;
    }

    public void setPaiementID(Long paiementID) {
        this.paiementID = paiementID;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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
}
