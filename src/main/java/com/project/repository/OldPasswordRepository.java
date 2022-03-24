package com.project.repository;


import com.project.domain.OldPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OldPasswordRepository extends JpaRepository<OldPassword, String> {
     List<OldPassword> findAllByIdUser(Long idUser);
     OldPassword findByHashpassword(String hashpassword);
}
