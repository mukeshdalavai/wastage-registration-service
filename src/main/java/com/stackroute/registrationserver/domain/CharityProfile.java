package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
public class CharityProfile {

        @Id
        private String username;
        private String charityName;
        private String email;
        private Long mobile;
        private String address;
        private String location;
        private Long foodRequirement;
        private Long certificateNo;
        private String certificateName;

        public CharityProfile(String username, String charityName, String email, Long mobile, String address, String location, Long foodRequirement, Long certificateNo, String certificateName) {
                this.username = username;
                this.charityName = charityName;
                this.email = email;
                this.mobile = mobile;
                this.address = address;
                this.location = location;
                this.foodRequirement = foodRequirement;
                this.certificateNo = certificateNo;
                this.certificateName = certificateName;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getCharityName() {
                return charityName;
        }

        public void setCharityName(String charityName) {
                this.charityName = charityName;
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

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public Long getFoodRequirement() {
                return foodRequirement;
        }

        public void setFoodRequirement(Long foodRequirement) {
                this.foodRequirement = foodRequirement;
        }

        public Long getCertificateNo() {
                return certificateNo;
        }

        public void setCertificateNo(Long certificateNo) {
                this.certificateNo = certificateNo;
        }

        public String getCertificateName() {
                return certificateName;
        }

        public void setCertificateName(String certificateName) {
                this.certificateName = certificateName;
        }
}


