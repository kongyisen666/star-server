package com.star.model;

import io.ebean.Ebean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    public void save(){
        this.setInsertedAt(new Date());
        this.setState(0);
        this.setType(0);
        Ebean.save(this);
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
