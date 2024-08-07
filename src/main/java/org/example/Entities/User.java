package org.example.Entities;

import org.example.Entities.Address;
import org.example.Entities.CreditCard;
import org.example.Entities.Employment;
import org.example.Entities.Subscription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public class User {
    private String id;
    private String uid;
    private String password;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phone_number;
    private LocalDate date_of_birth;
    private Employment employment;
    private Address address;
    private CreditCard credit_card;
    private Subscription subscription;

    private int age;

    public CreditCard getCredit_card() {
        return credit_card;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCredit_card(CreditCard credit_card) {
        this.credit_card = credit_card;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getUid() {
        return uid;
    }



    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public Employment getEmployment() {
        return employment;
    }

    public Address getAddress() {
        return address;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public int getAge() {
        if (date_of_birth != null) {

            return Period.between(date_of_birth, LocalDate.now()).getYears();
        }
         else {
        return 0;
     }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth=" + date_of_birth+
                ", age=" + getAge()+
                '}';
    }
}
