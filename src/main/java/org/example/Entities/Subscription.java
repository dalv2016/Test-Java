package org.example.Entities;

import lombok.Data;

@Data
public class Subscription {
    private String plan;
    private String status;
    private String payment_method;
    private String term;

}
