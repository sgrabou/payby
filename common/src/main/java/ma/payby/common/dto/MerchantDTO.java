package ma.payby.common.dto;


import ma.payby.common.enums.MerchantStatus;

public class MerchantDTO {
    private Long merchantID;
    private String name;
    private String userName;
    private String description;
    private String mobileNumber;
    private String email;
    private MerchantStatus merchantStatus;
    private String privateKey;
    private String publicKey;
    private String secretKey;
    private String paybyRedirectionURL;
    private String merchantResponseURL;
    private String urlWebsite;
    private String paybyVersion;
    private String logo;
    private WalletDTO wallet;

    public Long getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Long merchantID) {
        this.merchantID = merchantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MerchantStatus getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(MerchantStatus merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPaybyRedirectionURL() {
        return paybyRedirectionURL;
    }

    public void setPaybyRedirectionURL(String paybyRedirectionURL) {
        this.paybyRedirectionURL = paybyRedirectionURL;
    }

    public String getMerchantResponseURL() {
        return merchantResponseURL;
    }

    public void setMerchantResponseURL(String merchantResponseURL) {
        this.merchantResponseURL = merchantResponseURL;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public String getPaybyVersion() {
        return paybyVersion;
    }

    public void setPaybyVersion(String paybyVersion) {
        this.paybyVersion = paybyVersion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
