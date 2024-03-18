package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private String user_id;
    @Column(unique = true)
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @Size(min = 8, max = 16)
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
