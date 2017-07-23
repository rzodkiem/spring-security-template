package com.rzodkiewicz.michal.security;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", length = 50)
    @Enumerated(EnumType.STRING)
    private RoleEnum name = RoleEnum.USER;

    enum RoleEnum{
        USER
    }

}
