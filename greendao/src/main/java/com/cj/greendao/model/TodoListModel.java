package com.cj.greendao.model;

import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.manager.GreendaoManager;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by cj on 2020/12/7.
 */
public class TodoListModel extends BaseSqliteModel<Long, TodoBean> {

    @Override
    protected AbstractDao<TodoBean, Long> initDao() {
        return GreendaoManager.getInstance().getDaoSession().getTodoBeanDao();
    }

}
