package com.aiassistant.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    @NotBlank(message = "User ID cannot be blank")
    private String userId;
    
    @NotBlank(message = "Name cannot be blank")
    private String name;
    
    @NotBlank(message = "ID card number cannot be blank")
    @Pattern(regexp = "\\d{17}[\\d|x]|\\d{15}", message = "Invalid ID card number")
    private String idCard;
    
    @NotBlank(message = "Password cannot be blank")
    private String password;
    
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
    
    @NotNull(message = "Ethnicity cannot be null")
    private Ethnicity ethnicity;
    
    private BigDecimal balance;
    
    private String remark;
    
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Invalid phone number")
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public enum Gender {
        MALE, FEMALE
    }
    
    public enum Ethnicity {
        HAN, MONGOL, TIBETAN, UYGHUR, ZHUANG, OTHER
    }
}
