package com.lms.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    private String role_id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "user_role_pk.role", cascade = CascadeType.ALL)
    private Set<User_Role> user;
}
