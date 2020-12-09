package com.cj.greendao.entity;

import com.cj.base.Constant;
import com.cj.base.utils.TimeUtil;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by cj on 2020/12/7.
 */
@Entity
public class TodoBean {

    @Id
    private long pubTimeMillis;//发布时间戳
    
    private String pubTimeFormat;//发布时间字符串2020-10-20 12:20:00


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

    @Generated(hash = 1074381487)
    public TodoBean(long pubTimeMillis, String pubTimeFormat, String content,
            int level) {
        this.pubTimeMillis = pubTimeMillis;
        this.pubTimeFormat = pubTimeFormat;
        this.content = content;
        this.level = level;
    }

    @Generated(hash = 1563990781)
    public TodoBean() {
    }

    public long getPubTimeMillis() {
        return this.pubTimeMillis;
    }

    public void setPubTimeMillis(long pubTimeMillis) {
        this.pubTimeMillis = pubTimeMillis;
    }

    public String getPubTimeFormat() {
        return this.pubTimeFormat;
    }

    public void setPubTimeFormat(String pubTimeFormat) {
        this.pubTimeFormat = pubTimeFormat;
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
