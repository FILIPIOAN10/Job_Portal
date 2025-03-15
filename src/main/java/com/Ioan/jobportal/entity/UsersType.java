package com.Ioan.jobportal.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    private String userTypeName;
    @OneToMany(targetEntity = Users.class,mappedBy = "userTypeId",cascade = CascadeType.ALL)
    private List<Users> users;

    public UsersType() {
    }

    public UsersType(int userTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public UsersType setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
        return this;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public UsersType setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
        return this;
    }

    public List<Users> getUsers() {
        return users;
    }

    public UsersType setUsers(List<Users> users) {
        this.users = users;
        return this;
    }


}
