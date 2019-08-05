package ma.payby.common.jpa.model;


import ma.payby.common.enums.MerchandStatus;

import javax.persistence.*;

@Entity
public class Merchand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long merchandID;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String userName;
    private String description;
    private String mobileNumber;
    private String email;
    @Column(name="status")
    private MerchandStatus merchandStatus;
    private String privateKey;
    private String publicKey;
    private String paybyRedirectionURL;
    private String merchandResponseURL;
    private String urlWebsite;
    private String paybyVersion;

    public Long getMerchandID() {
        return merchandID;
    }

    public void setMerchandID(Long merchandID) {
        this.merchandID = merchandID;
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

    public MerchandStatus getMerchandStatus() {
        return merchandStatus;
    }

    public void setMerchandStatus(MerchandStatus merchandStatus) {
        this.merchandStatus = merchandStatus;
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

    public String getMerchandResponseURL() {
        return merchandResponseURL;
    }

    public void setMerchandResponseURL(String merchandResponseURL) {
        this.merchandResponseURL = merchandResponseURL;
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
}
