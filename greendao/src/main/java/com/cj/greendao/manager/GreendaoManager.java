package com.cj.greendao.manager;


import com.cj.baselibrary.application.MyKernel;
import com.cj.greendao.entity.DaoMaster;
import com.cj.greendao.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by cj on 2020/2/21.
 * 新写的greendao框架，MVC架构，简单好用。
 */
public class GreendaoManager {

    private static GreendaoManager instance = new GreendaoManager();
    private DaoSession daoSession;
    private Database db;

    private GreendaoManager() {
    }

    /**
     * 初始化建立数据库，可以在application启动时建表
     */
    public void init(String dbPath) {
        DaoMaster.OpenHelper helper = new DBOpenHelper(MyKernel.getInstance().getContext(), dbPath);
        helper.setLoadSQLCipherNativeLibs(false);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }


    public static GreendaoManager getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }


}
