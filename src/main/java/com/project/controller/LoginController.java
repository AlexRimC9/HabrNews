package com.project.controller;


import com.project.annotation.CheckingTime;
import com.project.domain.TableFriendList;
import com.project.domain.User;
import com.project.domain.UserDTO;
import com.project.exp.LoginFailExp;
import com.project.exp.ThisLoginExistedExp;
import com.project.exp.ThisPasswordExistedExp;
import com.project.repository.UserRepository;
import com.project.service.JwtUserDetailsService;
import com.project.service.LoginService;
import com.project.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class LoginController {
    private final LoginService loginService;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final JwtUserDetailsService jwtUserDetailsService;


    public LoginController(LoginService loginService, TokenService tokenService, UserRepository userRepository, UserDetailsService userDetailsService, JwtUserDetailsService jwtUserDetailsService){
        this.loginService = loginService;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }
    @Deprecated
    @PostMapping("/login")
    public void  login(@RequestParam String login, @RequestParam String password) throws LoginFailExp {
        loginService.login(login, password);

    }
    @Deprecated
    @PostMapping("/admin/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(jwtUserDetailsService.save(user));
    }

    @CheckingTime()
    @DeleteMapping("/admin/{id}/delete")
    public void deleteUser(@PathVariable Long id ) {
            userRepository.deleteById(id);
    }

    @PostMapping("/user/addToFriends")
    public void addFriends(@RequestParam Long yourId, @RequestParam Long IdFriend){
        loginService.addFriends(yourId,IdFriend);
    }

    @GetMapping("user/friends/all")
    public List<TableFriendList> allFriends(@RequestParam String login){
       return loginService.getFriendList(login);
    }

    @PostMapping("user/changingPassword")
    public void changePassword(@RequestParam String login,@RequestParam String newPassword) throws ThisPasswordExistedExp {
            loginService.changePassword(login, newPassword);
    }
    @PostMapping("user/changingLogin")
    public void changeLogin(@RequestParam String login,@RequestParam String newLogin) throws ThisLoginExistedExp {
        loginService.changeLogin(login,newLogin);
    }

    @GetMapping("user/friends/{fragmentSearch}/search")
    public List<User> friendsSearch(@PathVariable String fragmentSearch){
       return loginService.search(fragmentSearch);
    }
}
