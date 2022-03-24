package com.project.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "fridendList")
@Entity
public class TableFriendList {

    @Id
    @Column
    private Long idTransaction;

    @Column
    private Long idFriendToSearch;

    @Column
    private Long idHisFriends;

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Long getIdFriendToSearch() {
        return idFriendToSearch;
    }

    public void setIdFriendToSearch(Long idFriendToSearch) {
        this.idFriendToSearch = idFriendToSearch;
    }

    public Long getIdHisFriends() {
        return idHisFriends;
    }

    public void setIdHisFriends(Long idHisFriends) {
        this.idHisFriends = idHisFriends;
    }

}
