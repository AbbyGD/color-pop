package com.example.demo.enity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wj
 * @date 2018/7/10
 */
public class Cards implements Serializable {
    private int id;
    private String cardId;
    private int balance;
    private String beginTimestamp;
    private String brandName;
    private String cardType;
    private String createTimestamp;
    private String dateType;
    private String description;
    private String endTimestamp;
    private int fixedTerm;
    private int getLimit;
    private String notice;
    private String platformId;
    private int quantity;
    private String servicePhone;
    private String subTitle;
    private String title;
    private boolean useCustomCode;
    private String codes;
    private String status;
    private Integer receiveType; //领取类型
    private Integer platformType;//平台类型
    private String beginUseTimestamp;
    private String endUseTimestamp;
    private Integer receiveCount; //当前用户领取的数量

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }

    public String getBeginUseTimestamp() {
        return beginUseTimestamp;
    }

    public void setBeginUseTimestamp(String beginUseTimestamp) {
        this.beginUseTimestamp = beginUseTimestamp;
    }

    public String getEndUseTimestamp() {
        return endUseTimestamp;
    }

    public void setEndUseTimestamp(String endUseTimestamp) {
        this.endUseTimestamp = endUseTimestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBeginTimestamp() {
        return beginTimestamp;
    }

    public void setBeginTimestamp(String beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public int getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(int fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public int getGetLimit() {
        return getLimit;
    }

    public void setGetLimit(int getLimit) {
        this.getLimit = getLimit;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Cards{" +
                "cardId='" + cardId + '\'' +
                ", balance=" + balance +
                ", beginTimestamp='" + beginTimestamp + '\'' +
                ", brandName='" + brandName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", createTimestamp='" + createTimestamp + '\'' +
                ", dateType='" + dateType + '\'' +
                ", description='" + description + '\'' +
                ", endTimestamp='" + endTimestamp + '\'' +
                ", fixedTerm=" + fixedTerm +
                ", getLimit=" + getLimit +
                ", notice='" + notice + '\'' +
                ", platformId='" + platformId + '\'' +
                ", quantity=" + quantity +
                ", servicePhone='" + servicePhone + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", title='" + title + '\'' +
                ", useCustomCode=" + useCustomCode +
                ", codes='" + codes + '\'' +
                ", status='" + status + '\'' +
                ", receiveType=" + receiveType +
                ", platformType=" + platformType +
                ", beginUseTimestamp='" + beginUseTimestamp + '\'' +
                ", endUseTimestamp='" + endUseTimestamp + '\'' +
                '}';
    }
}
