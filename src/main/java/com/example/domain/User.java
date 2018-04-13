package com.example.domain;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int id;

    private String Name;

    private int age;
}
