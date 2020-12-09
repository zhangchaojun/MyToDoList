package com.example.mytodolist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.baselibrary.utils.StatusBarUtil;
import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.model.TodoListModel;
import com.example.mytodolist.R;
import com.example.mytodolist.ui.adapter.TodoListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRvTodo;
    private ImageView mIvAdd;
    private TodoListAdapter todoListAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

        }
    };
    private List<TodoBean> todoBeans;
    private TodoListModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        StatusBarUtil.setDarkMode(this);

        initView();
        initRecyclerView();
    }


    private void initView() {

        mRvTodo = findViewById(R.id.rv_todo);
        mIvAdd = findViewById(R.id.iv_add);
        mIvAdd.setOnClickListener(this);
    }

    private void initRecyclerView() {
        todoListAdapter = new TodoListAdapter(this);
        todoListAdapter.setOnItemClickListener(new TodoListAdapter.OnItemClickListener() {
            @Override
            public void itemClicked(int positon) {
                TodoBean todoBean = todoBeans.get(positon);
                todoBean.setChecked(!todoBean.isChecked());
                model.update(todoBean);

                todoListAdapter.notifyDataSetChanged();
            }
        });
        mRvTodo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvTodo.setAdapter(todoListAdapter);
    }

    private void refreshData() {
        model = new TodoListModel();
        todoBeans = model.queryAll();
        todoListAdapter.setList(todoBeans);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_add:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
            default:
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        refreshData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }
}