package com.example.modules;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "ONBOARD_INFO")
@NamedQuery(name = "getOnboardInfoByUserId", query = "SELECT o FROM OnboardInfo o WHERE o.userId = :userId")
@NamedQuery(name = "getOnboardList", query = "SELECT o FROM OnboardInfo o")

public class OnboardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ONBOARD_ID")
    private Integer onboardId; // primary key for the table

    @Column(name = "USER_ID",unique = true,nullable = false)
    private String userId; // unique id for each

    @Column(name = "ROLE" , nullable = false)
    private String role; // investor-o-buyer or lisiting you company on the app

    @Column(name = "ONBOARD_NAME" , unique = true , nullable = false)
    private String onboardName; // user name that user chooses

    @Column(name = "ONBOARD_EMAIL",nullable = false)
    private String onboardEmail;

    @Column(name = "PAN_ID" , nullable = false)
    private String panId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_OF_INCORPORATION")
    private Date dateOfIncorporation; // the dat company was approved by government

    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName; // users actual name

    @Column(name = "ACCOUNT_NUMBER" ,nullable = false)
    private String accountNumber;

    @Column(name = "IFSC_CODE" ,nullable = false )
    private String ifscCode;


    public OnboardInfo(String onboardName, String userId) {
        this.onboardName = onboardName;
        this.userId = userId;
    }

    // Getters and Setters
    public Integer getOnboardId() {
        return onboardId;
    }

    public void setOnboardId(Integer onboardId) {
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

     public OnboardInfo() {}

    @Override
    public String toString() {
        return "OnboardInfo{" +
                "userId='" + userId + '\'' +
                ", onboardName='" + onboardName + '\'' +
                '}';
    }

}
