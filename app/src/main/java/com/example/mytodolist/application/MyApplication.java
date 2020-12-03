package com.example.mytodolist.application;

import com.cj.baselibrary.application.MyBaseApplication;
import com.cj.baselibrary.utils.LogUtil;

/**
 * Created by cj on 2020/12/4.
 */
public class MyApplication extends MyBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);
    }
}
