package com.example.mytodolist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cj.base.utils.TimeUtil;
import com.cj.baselibrary.utils.StatusBarUtil;
import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.model.TodoListModel;
import com.example.mytodolist.R;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtContent;
    private Button mBtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.white));
        StatusBarUtil.setDarkMode(this);
        initView();
    }

    private void initView() {
        mEtContent = findViewById(R.id.et_content);
        mBtConfirm = findViewById(R.id.bt_confirm);
        mBtConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_confirm) {
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
}