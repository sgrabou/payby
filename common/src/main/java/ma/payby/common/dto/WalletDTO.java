package ma.payby.common.dto;

import ma.payby.common.enums.WalletStatus;

public class WalletDTO {
    private Long walletID;
    private String walletName;
    private String walletDescription;
    private String walletOwner;
    private String apiKey;
    private WalletStatus walletStatus;
    private String logo;

    public Long getWalletID() {
        return walletID;
    }

    public void setWalletID(Long walletID) {
        this.walletID = walletID;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletDescription() {
        return walletDescription;
    }

    public void setWalletDescription(String walletDescription) {
        this.walletDescription = walletDescription;
    }

    public String getWalletOwner() {
        return walletOwner;
    }

    public void setWalletOwner(String walletOwner) {
        this.walletOwner = walletOwner;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public WalletStatus getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(WalletStatus walletStatus) {
        this.walletStatus = walletStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
