package com.star.model;

import io.ebean.Ebean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_children")
public class Children {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name ="name")
    private String name;

    @Column(name ="age")
    private Integer age;

    @Column(name ="sex")
    private String sex;

    @Column(name ="phone")
    private String phone;

    @Column(name ="hobby")
    private String hobby;

    @Column(name ="score")
    private Integer score;

    @Column(name ="updated_at")
    private Date updatedAt;

    @Column(name ="deleted")
    private Integer deleted;
    public void save(){
        this.setScore(0);
        this.setUpdatedAt(new Date());
        Ebean.save(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
