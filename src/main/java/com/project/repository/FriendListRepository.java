package com.project.repository;

import com.project.domain.TableFriendList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendListRepository extends JpaRepository<TableFriendList,Long> {
 List<TableFriendList> findAllByIdFriendToSearch(Long idFriendToSearch);
}
