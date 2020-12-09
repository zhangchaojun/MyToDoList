package com.example.mytodolist.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cj.base.utils.TimeUtil;
import com.cj.baselibrary.utils.StatusBarUtil;
import com.cj.baselibrary.utils.ToastUtil;
import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.model.TodoListModel;
import com.example.mytodolist.R;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtContent;
    private Button mBtConfirm;
    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        StatusBarUtil.setDarkMode(this);
        initView();
    }

    private void initView() {
        mEtContent = findViewById(R.id.et_content);
        mBtConfirm = findViewById(R.id.bt_publish);
        mIvBack = findViewById(R.id.iv_back);
        mBtConfirm.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_publish) {
            publish();
        }

        if (id == R.id.iv_back || id == R.id.tv_back) {
            finish();
        }
    }

    private void publish() {
        String content = mEtContent.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            ToastUtil.show("发布内容为空");
            return;
        }

        TodoListModel model = new TodoListModel();
        TodoBean level1Bean = new TodoBean();
        level1Bean.setContent(mEtContent.getText().toString().trim());
        level1Bean.setLevel(1);
        level1Bean.setPubTimeFormat(TimeUtil.getFormatDate());
        level1Bean.setPubTimeMillis(TimeUtil.getTimeMillis());
        model.insertOrReplace(level1Bean);
        finish();
    }
}