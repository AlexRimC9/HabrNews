package com.project.service;

import com.project.domain.User;
import com.project.domain.UserDTO;
import com.project.exp.LoginFailExp;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + login);
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                new ArrayList<>());
        }

    public User save(UserDTO user) throws LoginFailExp {
        User newUser = new User();
        User userFromDB = userRepository.findByLogin(user.getLogin());

        if (userFromDB != null) {
            log.info("This login busy", user.getLogin());
        }
        newUser.setLogin(user.getLogin());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        newUser.setRoles(Collections.singleton(new Role(1L, "ROLE_USER"))); TODO я не помню
        return userRepository.save(newUser);
    }
}
