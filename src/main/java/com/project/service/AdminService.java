//package com.project.service;
//
//import com.project.domain.Role;
//import com.project.domain.User;
//import com.project.repository.RoleRepository;
//import com.project.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class AdminService {
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    UserRepository userRepository;
//
//    public void addUserAdminRole(User user){
//       User userOnUp = userRepository.findByLogin(user.getLogin());
//       if (userOnUp == null) {
//           log.warn("User {} is not found ", user.getLogin());
//
//       }else {
//           Role userOnUpInRole = roleRepository.findById(userOnUp.getIdUser()).get();
//           userOnUpInRole.setName("ROLE_ADMIN");
//           roleRepository.save(userOnUpInRole);
//       }
//    }
//}
