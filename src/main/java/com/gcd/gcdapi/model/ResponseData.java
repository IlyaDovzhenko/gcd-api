package com.gcd.gcdapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ResponseData {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ResponseStatus status;

    private Long result;
    private String error;
}
