package ma.payby.common.enums;

public enum WalletStatus {
    ACTIVE(1,"Active"),
    DESACTIVE(0,"Desactive");

    public final int code;
    public final String label;

    private WalletStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }
}
