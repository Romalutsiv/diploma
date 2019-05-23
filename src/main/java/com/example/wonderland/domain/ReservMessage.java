package com.example.wonderland.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ReservMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String firstname;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String secondname;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String phone;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String email;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String date;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String message;

    private boolean active = true;

    public boolean unActive(){
        return this.active = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ReservMessage() {
    }

    public ReservMessage(String firstname, String secondname, String phone, String email, String message) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.phone = phone;
        this.email = email;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
