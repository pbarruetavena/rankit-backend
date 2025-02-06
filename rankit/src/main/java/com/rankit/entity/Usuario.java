package com.rankit.entity;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
