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

    @Column(name ="birthday")
    private Date birthday;

    @Column(name ="grade")
    private Integer grade;

    @Column(name ="class")
    private Integer cla;

    @Column(name ="address")
    private String address;

    @Column(name ="school")
    private String school;

    @Column(name ="score")
    private Integer score;

    @Column(name ="updated_at")
    private Date updatedAt;

    @Column(name ="deleted")
    private Integer deleted;
    public void save(){
        this.setScore(0);
        this.setDeleted(0);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCla() {
        return cla;
    }

    public void setCla(Integer cla) {
        this.cla = cla;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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
