package com.example.mytodolist.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.base.utils.TimeUtil;
import com.cj.baselibrary.utils.StatusBarUtil;
import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.model.TodoListModel;
import com.example.mytodolist.R;
import com.example.mytodolist.ui.adapter.TodoListAdapter;

import java.util.Iterator;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int WHAT_REFRESH = 1;
    private static final int WHAT_NOTIFY_ITEM_REMOVED = 2;
    private RecyclerView mRvTodo;
    private ImageView mIvAdd;
    private TodoListAdapter todoListAdapter;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case WHAT_REFRESH:
                    refreshData();
                    break;
                case WHAT_NOTIFY_ITEM_REMOVED:
                    todoListAdapter.notifyItemRemoved(msg.arg1);
                    break;
                default:
            }

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

//        for (int i = 0; i < 20; i++) {
//
//            TodoListModel model = new TodoListModel();
//            TodoBean level1Bean = new TodoBean();
//            level1Bean.setContent("的的较紧急" + i);
//            level1Bean.setLevel(1);
//            level1Bean.setPubTimeFormat(TimeUtil.getFormatDate());
//            level1Bean.setPubTimeMillis(TimeUtil.getTimeMillis());
//            model.insertOrReplace(level1Bean);
//
//        }


    }


    private void initView() {

        mRvTodo = findViewById(R.id.rv_todo);
        mIvAdd = findViewById(R.id.iv_add);
        mIvAdd.setOnClickListener(this);
    }

    private void initRecyclerView() {
        initAinm();
        todoListAdapter = new TodoListAdapter(this);
        todoListAdapter.setOnItemClickListener(new TodoListAdapter.OnItemClickListener() {
            @Override
            public void itemClicked(final int position) {
                TodoBean todoBean = todoBeans.get(position);
                todoBean.setChecked(!todoBean.isChecked());
                model.update(todoBean);

                todoListAdapter.notifyDataSetChanged();


//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        todoListAdapter.notifyItemRemoved(position);
//                    }
//                },500);
//
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        refreshData();
//                    }
//                },1500);
//                Message message = handler.obtainMessage();
//                message.what = WHAT_REFRESH;
//                handler.sendMessageDelayed(message, 1500);
            }
        });
        mRvTodo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvTodo.setAdapter(todoListAdapter);

    }

    private void refreshData() {
        model = new TodoListModel();
        todoBeans = model.queryAll();
        Iterator<TodoBean> iterator = todoBeans.iterator();
        while (iterator.hasNext()) {
            TodoBean next = iterator.next();
            boolean checked = next.isChecked();
            if (checked) {
                iterator.remove();
            }
        }

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

    private void initAinm() {
        //通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_right_in);
        //得到一个LayoutAnimationController对象；
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        //设置控件显示的顺序；
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //设置控件显示间隔时间；
        lac.setDelay(0.2f);
        //为ListView设置LayoutAnimationController属性；
        mRvTodo.setLayoutAnimation(lac);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }
}