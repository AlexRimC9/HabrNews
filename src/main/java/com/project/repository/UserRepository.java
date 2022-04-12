package com.project.repository;

import com.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    User findByIdUser(Long id);
    @Query(value = "SELECT * FROM USERS WHERE first_name LIKE %:fragmentSearch% OR second_name LIKE %:fragmentSearch%",
            nativeQuery = true)
    List<User> findAllWhereByFirstNameAndSecondNameLikeFragmentSearch(String fragmentSearch);
}


