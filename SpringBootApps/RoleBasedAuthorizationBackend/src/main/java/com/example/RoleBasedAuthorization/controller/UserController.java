package com.example.RoleBasedAuthorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.RoleBasedAuthorization.common.UserInstances;
import com.example.RoleBasedAuthorization.entity.BloodRequestStatus;
import com.example.RoleBasedAuthorization.entity.Users;
import com.example.RoleBasedAuthorization.repository.UsersRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public String joinGroup(@RequestBody Users user) {
        user.setRoles(UserInstances.DEFAULT_ROLE);//USER
        	String encryptedPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPwd);
            userRepository.save(user);	
     
           return "Hi " + user.getUserName() +" welcome to this blood donation app!";
           
           
           
    }
    //If loggedin user is ADMIN -> ADMIN OR MODERATOR
    //If loggedin user is MODERATOR -> MODERATOR

    @GetMapping("/access/{userId}/{userRole}")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('LABTECHNICIAN') or hasAuthority('DOCTOR')")
    public String giveAccessToUser(@PathVariable int userId, @PathVariable String userRole, Principal principal) {
        Users user = userRepository.findById(userId).get();
        List<String> activeRoles = getRolesByLoggedInUser(principal);
        String newRole = "";
        if (activeRoles.contains(userRole)) {
            newRole = user.getRoles() + "," + userRole;
            user.setRoles(newRole);
        }
        userRepository.save(user);
        return "Hi " + user.getUserName() + " New Role assign to you by " + principal.getName();
    }

    
    @GetMapping("/allUsers")
    @Secured("LABTECHNICIAN")
    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
    public List<Users> loadUsers(Users user) {
        return userRepository.findAll();
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('DONNOR')")
    public String testUserAccess() {
        return "Donnors can only access this API !";
    }

    private List<String> getRolesByLoggedInUser(Principal principal) {
        String roles = getLoggedInUser(principal).getRoles();
        List<String> assignRoles = Arrays.stream(roles.split(",")).collect(Collectors.toList());
        if (assignRoles.contains("LABTECHNICIAN")) {
            return Arrays.stream(UserInstances.LATECH_ACCESS).collect(Collectors.toList());
        }
        if (assignRoles.contains("DOCTOR")) {
            return Arrays.stream(UserInstances.DOC_ACCESS).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private Users getLoggedInUser(Principal principal) {
        return userRepository.findByUserName(principal.getName()).get();
    }
}
