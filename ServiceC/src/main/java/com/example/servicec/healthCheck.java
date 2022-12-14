package com.example.servicec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class healthCheck {

    @GeneratedValue
    @Id
    private Long id;

    private String service = "Service C";
    private boolean status = true;

}
