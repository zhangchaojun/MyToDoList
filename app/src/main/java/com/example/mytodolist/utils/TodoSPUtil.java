package com.example.mytodolist.utils;

import com.cj.baselibrary.utils.SPUtil;

/**
 * Created by cj on 2020/12/7.
 */
class TodoSPUtil {

    private static final String TAG = "TodoSPUtil";
    private static final String KEY_USER_CODE = "PERSON";//离线登录用户信息，包括


    public static void setUserCode(String userCode) {
        SPUtil.getInstance().put(KEY_USER_CODE, userCode);
    }

    public static String getUserCode() {
        return SPUtil.getInstance().getString(KEY_USER_CODE, "");
    }

}
