package com.boat.service;

import com.boat.model.CategoryModel;
import com.boat.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryRepository.getCategoryModel(id);
    }

    public CategoryModel update(CategoryModel category) {
        if(category.getId() != null){
            Optional<CategoryModel>categoryEncontrado = categoryRepository.getCategoryModel(category.getId());
            if(!categoryEncontrado.isEmpty()){
                if(category.getDescription() != null){
                    categoryEncontrado.get(). setDescription(category.getDescription());
                }
                if(category.getName() != null ){
                    categoryEncontrado.get().setName(category.getName());

                }
                return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }
    public CategoryModel save(CategoryModel category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<CategoryModel> categoryEncontrado = categoryRepository.getCategoryModel(category.getId());
            if (categoryEncontrado.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
}

