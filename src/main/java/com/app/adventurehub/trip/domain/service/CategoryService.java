package com.app.adventurehub.trip.domain.service;

import com.app.adventurehub.trip.domain.model.entity.Category;

import java.util.List;

public interface CategoryService {
    void seed();
    List<Category> getAll();
}
