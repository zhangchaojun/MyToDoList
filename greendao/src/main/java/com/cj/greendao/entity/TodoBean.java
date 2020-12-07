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

    //内容
    private String content;
    
    /**
     * 紧急程度
     * 1 不重要
     * 2 一般
     * 3 重要
     * 4 紧急
     */
    private int level;

    @Generated(hash = 42866239)
    public TodoBean(String pubTime, String content, int level) {
        this.pubTime = pubTime;
        this.content = content;
        this.level = level;
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

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
