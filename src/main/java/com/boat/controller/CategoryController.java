package com.boat.controller;

import com.boat.model.CategoryModel;
import com.boat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategory(@PathVariable("id") Integer id){ //
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel save(@RequestBody CategoryModel category){
        return categoryService.save(category);
    }

}

