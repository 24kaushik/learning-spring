package com.example.springsecurityauth.service;

import com.example.springsecurityauth.entity.Role;
import com.example.springsecurityauth.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        Role newRole = new Role();
        newRole.setName(role.getName());

        roleRepository.save(newRole);
    }
}
