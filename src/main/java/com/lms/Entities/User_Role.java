package com.lms.Entities;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name="user_role_pk.user",
                joinColumns = @jakarta.persistence.JoinColumn(name="user_id")),
        @AssociationOverride(name="user_role_pk.role",
                joinColumns = @jakarta.persistence.JoinColumn(name="role_id"))
})
public class User_Role {

    @EmbeddedId
    private User_Role_PK user_role_pk;
    private Date last_Updated;
}