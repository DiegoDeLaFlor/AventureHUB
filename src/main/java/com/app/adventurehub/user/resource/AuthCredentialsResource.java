package com.app.adventurehub.user.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AuthCredentialsResource {
    private String email;
    private String password;
}
