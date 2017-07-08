package com.rzodkiewicz.michal.security.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "registered_user")
@Data
@Builder
public class RegisteredUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registered_user_id")
    private Long id;

    @Column(length = 50)
    private String username;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "register_code")
    private String registerCode;

    @Column(name = "registration_date")
    private Date registrationDate;
}
