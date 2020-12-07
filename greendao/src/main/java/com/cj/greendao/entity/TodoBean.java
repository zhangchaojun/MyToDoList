package com.cj.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cj on 2020/12/7.
 */
@Entity
public class TodoBean {

    @Id
    private String pubTime;

    private String content;

    @Generated(hash = 2008293618)
    public TodoBean(String pubTime, String content) {
        this.pubTime = pubTime;
        this.content = content;
    }

    @Generated(hash = 1563990781)
    public TodoBean() {
    }

    public String getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
