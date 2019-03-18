package com.star.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_score_log")
public class ScoreLog {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "children_id")
    private Integer childrenId;

    @Column(name = "msg")
    private String msg;

    @Column(name = "inserted_at")
    private String insertedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(Integer childrenId) {
        this.childrenId = childrenId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(String insertedAt) {
        this.insertedAt = insertedAt;
    }
}
