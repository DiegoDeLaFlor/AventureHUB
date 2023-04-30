package com.app.adventurehub.trip.service;

import com.app.adventurehub.trip.domain.model.entity.Category;
import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.enumeration.Categories;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import com.app.adventurehub.trip.domain.persistence.CategoryRepository;
import com.app.adventurehub.trip.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    private static String[] DEFAULT_CATEGORIES= { "ADVENTURE", "ENTERTAINMENT", "EXCLUSIVE",
            "GASTRONOMY", "CULTURAL", "NATURE", "EXPERIENTIAL"};

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_CATEGORIES)
                .forEach(name -> {
                    Categories categoryName = Categories.valueOf(name);
                    if(!categoryRepository.existsByName(categoryName)) {
                        categoryRepository.save((new Category()).withName(categoryName));
                    }
                });
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
