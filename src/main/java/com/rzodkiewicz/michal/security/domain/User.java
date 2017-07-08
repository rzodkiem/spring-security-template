package com.rzodkiewicz.michal.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "security_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50)
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean enabled;

    @Column(name = "creation_date")
    private Date creationDate;

}
