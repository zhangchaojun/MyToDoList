package com.example.mytodolist.application;

import com.cj.baselibrary.application.MyBaseApplication;
import com.cj.baselibrary.utils.LogUtil;
import com.cj.greendao.manager.GreendaoManager;

import java.io.File;

/**
 * Created by cj on 2020/12/4.
 */
public class MyApplication extends MyBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);
        GreendaoManager.getInstance().init("todolist.db");
    }
}
