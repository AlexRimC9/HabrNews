package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    private String name;
    @Transient
    @ManyToMany
    @JoinTable(
            name = "roles_privilege",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "idRole"),
            inverseJoinColumns = @JoinColumn(
                    name = "id_privilege", referencedColumnName = "idPrivelege"))
    private Set<Privilege> privileges;

    public Role(Long id) {
        this.idRole = id;
    }

    public Role(Long id, String name) {
        this.idRole = id;
        this.name = name;
    }


    public Role() {

    }


    @Override
    public String getAuthority() {
        return getName();
    }
}
