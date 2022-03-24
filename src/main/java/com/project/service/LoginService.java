package com.project.service;


import com.project.component.WebSecurityConfig;
import com.project.domain.OldPassword;
import com.project.domain.TableFriendList;
import com.project.domain.User;
import com.project.exp.LoginFailExp;
import com.project.exp.ThisLoginExistedExp;
import com.project.exp.ThisPasswordExistedExp;
import com.project.repository.FriendListRepository;
import com.project.repository.OldPasswordRepository;
import com.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class LoginService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final FriendListRepository friendListRepository;
    private final OldPasswordRepository oldPasswordRepository;
    private final WebSecurityConfig webSecurityConfig;


    public LoginService(UserRepository userRepository, TokenService tokenService, FriendListRepository friendListRepository, OldPasswordRepository oldPasswordRepository, WebSecurityConfig webSecurityConfig) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.friendListRepository = friendListRepository;
        this.oldPasswordRepository = oldPasswordRepository;
        this.webSecurityConfig = webSecurityConfig;
    }

    @Deprecated
    public void login(String login, String password) throws LoginFailExp {
        User user = userRepository.findByLogin(login);
    }

    // Добавление в друзья
    public void addFriends(Long yourId , Long friendId){ // через id
        User yourUser = userRepository.findByIdUser(yourId); // метод который обьеденяет не нужен
        User friendUser = userRepository.findByIdUser(friendId);
        TableFriendList transaction = new TableFriendList();
        transaction.setIdFriendToSearch(yourUser.getIdUser());
        transaction.setIdHisFriends(friendUser.getIdUser());
        transaction.setIdFriendToSearch(friendUser.getIdUser());
        transaction.setIdHisFriends(yourUser.getIdUser());
        friendListRepository.save(transaction);
    }
    //получение списка друзей
    public List<TableFriendList> getFriendList(String login){
        return friendListRepository.findAllByIdFriendToSearch(userRepository.findByLogin(login).getIdUser());
    }
    //изменение пароля
    public void changePassword(String login,String newPassword) throws ThisPasswordExistedExp {
        OldPassword oldPassword = new OldPassword();
        oldPassword.setHashpassword(userRepository.findByLogin(login).getPassword());
        oldPassword.setIdUser(userRepository.findByLogin(login).getIdUser());
        String newPasswordHash =  bcryptEncoder.encode(newPassword);
        if (oldPasswordRepository.findByHashpassword(newPasswordHash) != null) {
            try {
                throw new ThisPasswordExistedExp();
            } catch (ThisPasswordExistedExp e) {
                log.error("Repeat password,login = {}", login);
            }
        }
        else {
                User user = userRepository.findByLogin(login);
                user.setPassword(bcryptEncoder.encode(newPassword));
                userRepository.save(user);
            }
    };

    public void changeLogin(String login, String newLogin) throws ThisLoginExistedExp {
        User user = userRepository.findByLogin(login);
        if (userRepository.findByLogin(newLogin) != null){
            try {
                throw new ThisLoginExistedExp();
            }catch (ThisLoginExistedExp e){
                log.error("This login already in use = {} repeat login",newLogin);
            }
        }
        user.setLogin(newLogin);
        userRepository.save(user);
    }


    // поиск друзей по отрезкам
   public List<User> search(String fragmentSearch){
        return userRepository.findAllWhereByFirstNameAndSecondNameLikeFragmentSearch(fragmentSearch);
   }
}


