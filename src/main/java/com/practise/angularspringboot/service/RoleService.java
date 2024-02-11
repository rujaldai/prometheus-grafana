package com.practise.angularspringboot.service;

import com.practise.angularspringboot.entity.Role;
import com.practise.angularspringboot.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Value("${test}")
    private String test;

    // function to create a new role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    // function return a role by id or null in case it doesn't exist
    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }
    // function that retrieve all roles from database
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    // function that update an existing role in database
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
    // function that remove a role from database by it's id
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}