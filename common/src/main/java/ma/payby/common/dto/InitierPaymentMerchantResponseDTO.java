package ma.payby.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitierPaymentMerchantResponseDTO {
    @JsonProperty("MERCHANT_ID")
    private String merchantUserName;
    @JsonProperty("REFERENCE_ID")
    private String orderReference;
    @JsonProperty("PayBy_URL")
    private String redirectionURL;
    @JsonProperty("ORDER_ID")
    private String merchantOrderID;
    @JsonProperty("PayBy_MESSAGE_VERSION")
    private String versionPayby;
    @JsonProperty("TRACK_ID")
    private String trackID;
    @JsonProperty("RESPONSE_CODE")
    private String responseCode;



    public String getMerchantUserName() {
        return merchantUserName;
    }

    public void setMerchantUserName(String merchantUserName) {
        this.merchantUserName = merchantUserName;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getRedirectionURL() {
        return redirectionURL;
    }

    public void setRedirectionURL(String redirectionURL) {
        this.redirectionURL = redirectionURL;
    }

    public String getMerchantOrderID() {
        return merchantOrderID;
    }

    public void setMerchantOrderID(String merchantOrderID) {
        this.merchantOrderID = merchantOrderID;
    }

    public String getVersionPayby() {
        return versionPayby;
    }

    public void setVersionPayby(String versionPayby) {
        this.versionPayby = versionPayby;
    }

    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
