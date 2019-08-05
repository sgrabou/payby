package ma.payby.common.dto;

import ma.payby.common.enums.OrderStatus;

public class OrderEditStatusRequestDTO {
   private Long id;
   private OrderStatus orderStatus;

    public OrderEditStatusRequestDTO(Long id, OrderStatus orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
