package org.example.Entities;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String street_name;
    private String street_address;
    private String zip_code;
    private String state;
    private String country;
    private Coordinates coordinates;


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street_name='" + street_name + '\'' +
                ", street_address='" + street_address + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }


}
