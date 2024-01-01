package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String user_id;
    @Column(unique = true)
    private String email;
    @Size(min = 8, max = 16)
    private String password;
    @OneToMany(mappedBy = "user_role_pk.user", cascade = CascadeType.ALL)
    private Set<User_Role> roles;
}
