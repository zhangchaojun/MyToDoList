package com.cj.greendao.model;

import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.entity.TodoBeanDao;
import com.cj.greendao.manager.GreendaoManager;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by cj on 2020/12/7.
 */
public class TodoListModel extends BaseSqliteModel<Long, TodoBean> {

    @Override
    protected AbstractDao<TodoBean, Long> initDao() {
        return GreendaoManager.getInstance().getDaoSession().getTodoBeanDao();
    }

    /**
     * 根据发布时间倒序排列
     */
    public List<TodoBean> queryAllDesc() {
        QueryBuilder<TodoBean> todoBeanQueryBuilder = getGreenDao().queryBuilder().orderDesc(TodoBeanDao.Properties.PubTimeMillis);
        Query<TodoBean> build = todoBeanQueryBuilder.build();
        List<TodoBean> list = build.list();
        return list;
    }

}
