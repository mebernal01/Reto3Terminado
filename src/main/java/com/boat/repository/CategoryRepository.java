package com.boat.repository;

import com.boat.model.CategoryModel;
import com.boat.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAll(){
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategoryModel(int id){
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel save(CategoryModel category){
        return categoryCrudRepository.save(category);
    }

    public void delete(CategoryModel category){
        categoryCrudRepository.delete(category);
    }

    public CategoryModel updateCategory(CategoryModel categoryModel){
        return categoryCrudRepository.save(categoryModel);
    }
}
