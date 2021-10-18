package com.company.exttok.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;

@Table(name = "EXTTOK_USER_DETAILS")
@Entity(name = "exttok_UserDetails")
public class UserDetails extends StandardEntity {
    private static final long serialVersionUID = -6033522115681712369L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", unique = true)
    private User user;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}