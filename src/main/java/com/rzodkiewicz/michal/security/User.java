package com.rzodkiewicz.michal.security;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "security_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
class User {

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

}
