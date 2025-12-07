package com.example.modules;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "ONBOARD_INFO")
public class OnboardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ONBOARD_ID")
    private Integer onboardId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "ONBOARD_NAME")
    private String onboardName;

    @Column(name = "ONBOARD_EMAIL")
    private String onboardEmail;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_FK")
    private AddressInfo address_fk;

    @Column(name = "PAN_ID")
    private String panId;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "DATE_OF_INCORPORATION")
    private Date dateOfIncorporation;

    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    // Getters and Setters
    public Integer getonboardId() {
        return onboardId;
    }

    public void setonboardId(Integer onboardId) {
        this.onboardId = onboardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOnboardName() {
        return onboardName;
    }

    public void setOnboardName(String onboardName) {
        this.onboardName = onboardName;
    }

    public String getOnboardEmail() {
        return onboardEmail;
    }

    public void setOnboardEmail(String onboardEmail) {
        this.onboardEmail = onboardEmail;
    }

    public AddressInfo getAddress_fk() {
        return address_fk;
    }

    public void setAddress_fk(AddressInfo address_fk) {
        this.address_fk = address_fk;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(Date dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

}
