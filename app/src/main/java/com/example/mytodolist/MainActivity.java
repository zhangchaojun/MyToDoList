package com.example.mytodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cj.baselibrary.utils.SPUtil;
import com.cj.baselibrary.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SPUtil.getInstance().put("jj","kk");
        String jj = SPUtil.getInstance().getString("jj", "00");
        ToastUtils.show(this,jj);
    }
}