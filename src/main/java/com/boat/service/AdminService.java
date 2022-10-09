package com.boat.service;

import com.boat.model.AdminModel;
import com.boat.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAll() {
        return adminRepository.getAllAdmin();
    }

    public Optional<AdminModel> getAdminModel(int id) {
        return adminRepository.getAdminModel(id);
    }

    public AdminModel save(AdminModel admin) {
        if (admin.getIdAdminModel() == null) {
            return adminRepository.saveAdmin(admin);
        } else {
            Optional<AdminModel> adminEncontrado = adminRepository.getAdminModel(admin.getIdAdminModel());
            if (adminEncontrado.isEmpty()) {
                return adminRepository.saveAdmin(admin);
            } else {
                return admin;
            }
        }
    }

    public AdminModel update(AdminModel admin){
        if(admin.getIdAdminModel() != null){
            Optional<AdminModel>adminEncontrado = adminRepository.getAdminModel(admin.getIdAdminModel());
            if(!adminEncontrado.isEmpty()){
                if(admin.getPassword() != null){
                    adminEncontrado.get(). setPassword(admin.getPassword());
                }
                if(admin.getName() != null ){
                    adminEncontrado.get().setName(admin.getName());
                }
                return adminRepository.saveAdmin(adminEncontrado.get());
            }
        }
        return admin;
    }

    public boolean deleteAdminModel(int adminId){
        Boolean resultado = getAdminModel(adminId).map(adminPorEliminar ->{
            adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);

        return resultado;
    }
}
