package com.example.midproject;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class CreditCard {
    private String cardNo;
    private String holderName;
    private LocalDate dateOfExpire;
    private String cardType;
    private String gatewayName;
    private float creditLimit;

    public CreditCard(String cardNo, String holderName, LocalDate dateOfExpire, String cardType, String gatewayName, float creditLimit) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.dateOfExpire = dateOfExpire;
        this.cardType = cardType;
        this.gatewayName = gatewayName;
        this.creditLimit = creditLimit;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public LocalDate getDateOfExpire() {
        return dateOfExpire;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setDateOfExpire(LocalDate dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", holderName='" + holderName + '\'' +
                ", dateOfExpire=" + dateOfExpire +
                ", cardType='" + cardType + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }

    public CreditCard() {
        this.cardNo = null;
        this.holderName = null;
        this.dateOfExpire = null;
        this.cardType = null;
        this.gatewayName = null;
        this.creditLimit = 0;
    }

    public void showCardInfoToAlert() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(this.toString());
        a.showAndWait();
    }
}
