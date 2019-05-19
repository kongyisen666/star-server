package com.star.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_prize")
public class Prize {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "prize_1")
    private String prize1;

    @Column(name = "prize_2")
    private String prize2;

    @Column(name = "prize_3")
    private String prize3;

    @Column(name = "prize_4")
    private String prize4;

    @Column(name = "prize_5")
    private String prize5;

    @Column(name = "prize_6")
    private String prize6;

    @Column(name = "prize_7")
    private String prize7;

    @Column(name = "prize_8")
    private String prize8;

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

    public String getPrize1() {
        return prize1;
    }

    public void setPrize1(String prize1) {
        this.prize1 = prize1;
    }

    public String getPrize2() {
        return prize2;
    }

    public void setPrize2(String prize2) {
        this.prize2 = prize2;
    }

    public String getPrize3() {
        return prize3;
    }

    public void setPrize3(String prize3) {
        this.prize3 = prize3;
    }

    public String getPrize4() {
        return prize4;
    }

    public void setPrize4(String prize4) {
        this.prize4 = prize4;
    }

    public String getPrize5() {
        return prize5;
    }

    public void setPrize5(String prize5) {
        this.prize5 = prize5;
    }

    public String getPrize6() {
        return prize6;
    }

    public void setPrize6(String prize6) {
        this.prize6 = prize6;
    }

    public String getPrize7() {
        return prize7;
    }

    public void setPrize7(String prize7) {
        this.prize7 = prize7;
    }

    public String getPrize8() {
        return prize8;
    }

    public void setPrize8(String prize8) {
        this.prize8 = prize8;
    }
}
