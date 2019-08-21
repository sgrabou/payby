package ma.payby.common.enums;

public enum OrderStatus {
    ENATTENTE(1,"En attente"),
    CAPTURED(2,"Paiement accepté"),
    EXPIRE(3,"Order expirée"),
    REFUSE(4,"Paiement refusé");

    public final int code;
    public final String label;

    private OrderStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }

}