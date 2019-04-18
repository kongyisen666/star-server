package com.star.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_reward_punish")
public class RewardPunish {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score")
    private int score;

    @Column(name = "msg")
    private String msg;

    @Column(name = "state")
    private int state;

    @Column(name = "type")
    private int type;

    @Column(name = "inserter")
    private String inserter;

    @Column(name = "inserted_at")
    private String insertedAt;

    @Column(name = "deleted")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInserter() {
        return inserter;
    }

    public void setInserter(String inserter) {
        this.inserter = inserter;
    }

    public String getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(String insertedAt) {
        this.insertedAt = insertedAt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
