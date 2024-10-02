package org.example.Entities;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
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
