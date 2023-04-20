package com.app.adventurehub.user.domain.service;

import com.app.adventurehub.user.domain.model.entity.User;
import com.app.adventurehub.user.resource.AuthCredentialsResource;

import java.util.List;

public interface AuthService {
    User login (AuthCredentialsResource credentials);

    //List<User> findByBudgetTravelPackage(float value);
}
