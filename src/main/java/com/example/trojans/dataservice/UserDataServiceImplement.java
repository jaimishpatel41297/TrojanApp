/*
package com.com.trojans.dataservice;

import com.com.trojans.model.LoginRole;
import com.com.trojans.model.LoginUser;
import com.com.trojans.repository.RoleRepository;
import com.com.trojans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service
public class UserDataServiceImplement implements UserDataService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encyptPassword;

    @Autowired
    public UserDataServiceImplement(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encyptPassword) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encyptPassword = encyptPassword;
    }

    @Override
    public LoginUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public LoginUser saveUser(LoginUser user) {
        user.setPassword(encyptPassword.encode(user.getPassword()));
        user.setActive(1);
        LoginRole loginRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<LoginRole>(Arrays.asList(loginRole)));
        return userRepository.save(user);
    }
}
*/
