package com.star.service;

import com.star.model.User;
import io.ebean.Ebean;

import java.util.List;

public class UserService {

    public List<User> searchList() {
        return Ebean.find(User.class).where().eq("role", 0).eq("type", 1).eq("deleted", 0).orderBy("insertedAt desc").findList();
    }

}
