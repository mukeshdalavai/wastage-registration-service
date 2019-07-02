package com.stackroute.registrationserver.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
public class DeliveryBoyProfile {

    @Id
    private String username;
    private String deliveryBoyName;
    private String email;
    private Long mobile;
    private String address;
    private String licenseNo;
    private String licenseName;

    public DeliveryBoyProfile(String username, String deliveryBoyName, String email, Long mobile, String address, String licenseNo, String licenseName) {
        this.username = username;
        this.deliveryBoyName = deliveryBoyName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.licenseNo = licenseNo;
        this.licenseName = licenseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }
}
