package com.boat.controller;

import com.boat.model.AdminModel;
import com.boat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel>getAll(){
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AdminModel> getAdminModel(@PathVariable("id")int id){
        return adminService.getAdminModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel save(@RequestBody AdminModel admin){
        return adminService.save(admin);
    }

}
