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
public class RestaurantProfile {

    @Id
    private String username;
    private String restaurantName;
    private String email;
    private long mobile;
    private String address;
    private String location;
    private long certificateNo;
    private String certificateName;

    public RestaurantProfile(String username, String restaurantName, String email, long mobile, String address, String location, long certificateNo, String certificateName) {
        this.username = username;
        this.restaurantName = restaurantName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.location = location;
        this.certificateNo = certificateNo;
        this.certificateName = certificateName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public long getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(long certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
}
