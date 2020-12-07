package com.cj.greendao.model;


import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by cj on 2020/02/21.
 * K 主键类型
 * T 数据类型
 */

public abstract class BaseSqliteModel<K, T>  {

    private AbstractDao<T, K> mGreenDao = null;

    public BaseSqliteModel() {
        this(true);
    }

    public BaseSqliteModel(boolean isNeedDao) {
        if (isNeedDao) {
            mGreenDao = initDao();
            if (mGreenDao == null) {
                throw new NullPointerException("GreenDao can not be null");
            }
        }
    }


    protected abstract AbstractDao<T, K> initDao();



    /**
     * 将实体列表插入到表中，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insert(T... entities) {
        for (T entry : entities) {
            mGreenDao.insert(entry);
        }
    }

    /**
     * 将实体列表插入到表中，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertInTx(T... entities) {
        mGreenDao.insertInTx(entities);
    }

    /**
     * 将实体列表插入到表中，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public long insert(Iterable<T> entities) {
        try {
            long count = 0;
            for (T entry : entities) {
                mGreenDao.insert(entry);
                count++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将实体列表插入到表中，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertInTx(Iterable<T> entities) {
        mGreenDao.insertInTx(entities);
    }

    /**
     * 将实体列表插入到表中
     *
     * @param entities
     * @param setPrimaryKey 主键Id是否自动设置为当前行数
     */
    public void insertInTx(Iterable<T> entities, boolean setPrimaryKey) {
        mGreenDao.insertInTx(entities, setPrimaryKey);
    }

    /**
     * 若实体列表不存在，插入表中，若实体存在，则更新该实体，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertOrReplace(T... entities) {
        for (T entry : entities) {
            mGreenDao.insertOrReplace(entry);
        }
    }

    /**
     * 若实体列表不存在，插入表中，若实体存在，则更新该实体，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertOrReplaceInTx(T... entities) {
        mGreenDao.insertOrReplaceInTx(entities);
    }

    /**
     * 若实体列表不存在，插入表中，若实体存在，则更新该实体，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertOrReplace(Iterable<T> entities) {
        for (T entry : entities) {
            mGreenDao.insertOrReplace(entry);
        }
    }

    /**
     * 若实体列表不存在，插入表中，若实体存在，则更新该实体，主键Id会自动被设置为当前行数
     *
     * @param entities
     */
    public void insertOrReplaceInTx(Iterable<T> entities) {
        mGreenDao.insertOrReplaceInTx(entities);
    }

    /**
     * 若实体列表不存在，插入表中，若实体存在，则更新该实体
     *
     * @param entities
     * @param setPrimaryKey 主键Id是否自动设置为当前行数
     */
    public void insertOrReplace(Iterable<T> entities, boolean setPrimaryKey) {
        mGreenDao.insertOrReplaceInTx(entities, setPrimaryKey);
    }

    /**
     * 将一个实体插入到表中
     *
     * @param entity
     * @return 当前行数
     */
    public long insert(T entity) {
        return mGreenDao.insert(entity);
    }

    /**
     * 若实体不存在，插入表中，若实体存在，则更新该实体
     *
     * @param entity
     * @return 当前行数
     */
    public long insertOrReplace(T entity) {
        return mGreenDao.insertOrReplace(entity);
    }

    /**
     * 将实体插入到数据库中
     * Warning:慎用！只是将该实体代表的数据插入到数据库中，该类未建立与该实体的关联，
     * 即无法利用该实体对其对应的数据进行查询，修改，删除操作
     *
     * @param entity
     * @return 当前行数
     */
    public long insertWithoutSettingPk(T entity) {
        return mGreenDao.insertWithoutSettingPk(entity);
    }

    /**
     * 根据主键Id删除数据
     *
     * @param key
     */
    public long deleteByKey(K key) {
        try {
            mGreenDao.deleteByKey(key);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据主键Id删除数据
     *
     * @param key
     */
    public void deleteByKeyInTx(K key) {
        mGreenDao.deleteByKeyInTx(key);
    }

    /**
     * 根据主键Id列表删除数据
     *
     * @param keys
     */
    public void deleteByKeys(Iterable<K> keys) {
        for (K key : keys) {
            mGreenDao.deleteByKey(key);
        }
    }

    /**
     * 根据主键Id列表删除数据
     *
     * @param keys
     */
    public void deleteByKeysInTx(Iterable<K> keys) {
        mGreenDao.deleteByKeyInTx(keys);
    }


    /**
     * 根据主键Id列表删除数据
     *
     * @param keys
     */
    public void deleteByKeys(K... keys) {
        for (K key : keys) {
            mGreenDao.deleteByKey(key);
        }
    }

    /**
     * 根据主键Id列表删除数据
     *
     * @param keys
     */
    public void deleteByKeysInTx(K... keys) {
        mGreenDao.deleteByKeyInTx(keys);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        mGreenDao.deleteAll();
    }

    /**
     * 根据实体删除数据
     *
     * @param entity
     */
    public long delete(T entity) {
        try {
            mGreenDao.delete(entity);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据实体列表删除数据
     *
     * @param entities
     */
    public void delete(Iterable<T> entities) {
        for (T entry : entities) {
            mGreenDao.delete(entry);
        }
    }

    /**
     * 根据实体列表删除数据
     *
     * @param entities
     */
    public void deleteInTx(Iterable<T> entities) {
        mGreenDao.deleteInTx(entities);
    }

    /**
     * 根据实体列表删除数据
     *
     * @param entities
     */
    public void delete(T... entities) {
        for (T entry : entities) {
            mGreenDao.delete(entry);
        }
    }

    /**
     * 根据实体列表删除数据
     *
     * @param entities
     */
    public void deleteInTx(T... entities) {
        mGreenDao.deleteInTx(entities);
    }

    /**
     * 根据实体更新数据
     *
     * @param entity
     */
    public long update(T entity) {
        try {
            mGreenDao.update(entity);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据实体列表更新数据
     *
     * @param entities
     */
    public void update(T... entities) {
        for (T entry : entities) {
            mGreenDao.update(entry);
        }
    }

    /**
     * 根据实体列表更新数据
     *
     * @param entities
     */
    public void updateInTx(T... entities) {
        mGreenDao.updateInTx(entities);
    }

    /**
     * 根据实体列表更新数据
     *
     * @param entities
     */
    public long update(Iterable<T> entities) {
        try {
            for (T entry : entities) {
                mGreenDao.update(entry);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据实体列表更新数据
     *
     * @param entities
     */
    public void updateInTx(Iterable<T> entities) {
        mGreenDao.updateInTx(entities);
    }

    /**
     * 根据主键Id查询数据
     *
     * @param primaryKey
     * @return
     */
    public T queryByKey(K primaryKey) {
        return mGreenDao.load(primaryKey);
    }

    /**
     * 根据行数查询数据
     *
     * @param request
     * @return
     */
    public T queryByRowId(long request) {
        return mGreenDao.loadByRowId(request);
    }

    /**
     * 查询所有数据，如果没有则返回空list
     *
     * @return
     */
    public List<T> queryAll() {
        return mGreenDao.loadAll();
    }

    /**
     * 查询满足所有条件的所有实体列表
     *
     * @param cond
     * @param condMore
     * @return
     */
    public List<T> queryAnd(WhereCondition cond, WhereCondition... condMore) {
        return mGreenDao.queryBuilder().where(cond, condMore).list();
    }

    /**
     * 查询满足所有条件的单个实体
     *
     * @param cond
     * @param condMore
     * @return
     */
    public T queryAndUnique(WhereCondition cond, WhereCondition... condMore) {
        return mGreenDao.queryBuilder().where(cond, condMore).unique();
    }

    /**
     * 查询满足单个条件的所有实体
     *
     * @param cond1
     * @param cond2
     * @param condMore
     * @return
     */
    public List<T> queryOr(WhereCondition cond1, WhereCondition cond2, WhereCondition... condMore) {
        return mGreenDao.queryBuilder().whereOr(cond1, cond2, condMore).list();
    }

    public T queryOrUnique(WhereCondition cond1, WhereCondition cond2, WhereCondition... condMore) {
        return mGreenDao.queryBuilder().whereOr(cond1, cond2, condMore).unique();
    }

    /**
     * 计数
     */
    public long count(){
        return mGreenDao.queryBuilder().count();
    }

    public AbstractDao<T, K> getGreenDao() {
        return mGreenDao;
    }

}
