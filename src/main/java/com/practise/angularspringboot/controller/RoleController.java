package com.practise.angularspringboot.controller;

import com.practise.angularspringboot.entity.Role;
import com.practise.angularspringboot.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    private final RoleService roleService;
    //Create new Role
    @PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role newRole = roleService.createRole(role);
        return new ResponseEntity<Role>(newRole, HttpStatus.CREATED);
    }
    //Get role by id
    @GetMapping(path="/{roleId}",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRoleById(@PathVariable String roleId) {
        Role roleFound = roleService.getRoleById(roleId);
        return new ResponseEntity<Role>(roleFound,HttpStatus.OK);
    }
    //Get all roles
    @GetMapping(produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAllRoles() {
        log.info("Seleting all roles");
        List<Role> rolesList = roleService.getAllRoles();
        return new ResponseEntity<List<Role>>(rolesList,HttpStatus.OK);
    }
    //Update role
    @PutMapping(consumes =MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> updateUser(@RequestBody Role role){
        Role roleUpdated = roleService.updateRole(role);
        return new ResponseEntity<Role>(roleUpdated,HttpStatus.ACCEPTED);
    }
    //Delete role
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
