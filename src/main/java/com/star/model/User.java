package com.star.model;

import io.ebean.Ebean;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "state")
    private Integer state;//0未激活1已激活

    @Column(name = "type")
    private Integer type;//0未添加孩子1已添加孩子

    @Column(name = "password")
    private String password;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "inserted_at")
    private Date insertedAt;

    @Column(name = "role")
    private Integer role;

    @Transient
    List<Children> childrenList;

    public void save() {
        this.setInsertedAt(new Date());
        this.setState(0);
        this.setType(0);
        this.setDeleted(0);
        this.setRole(0);
        Ebean.save(this);
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Children> getChildrenList() {
        return Ebean.find(Children.class).where().eq("deleted", 0).eq("userId", this.getId()).findList();
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(Date insertedAt) {
        this.insertedAt = insertedAt;
    }
}
