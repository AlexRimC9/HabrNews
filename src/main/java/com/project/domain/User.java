package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,unique = true)
    private Long idUser;

    @Column
    private String login;


    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private String password;

    @Column
    private Integer age;

//    @Column
//    private Boolean enabled;
//
//    @Column
//    private String imgUrl;


    @Transient
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "idUsers"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "idRole"))
    private Set<Role> roles;
    // из промежуточной таблицы будет подгружать роль


    public User() {
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getLogin();
    }


}

