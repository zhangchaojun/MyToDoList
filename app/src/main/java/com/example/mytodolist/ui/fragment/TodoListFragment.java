package com.example.mytodolist.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.baselibrary.base.BaseFragment;
import com.cj.greendao.entity.TodoBean;
import com.cj.greendao.model.TodoListModel;
import com.example.mytodolist.R;
import com.example.mytodolist.ui.adapter.TodoListAdapter;

import java.util.List;

/**
 * Created by cj on 2020/12/7.
 */
public class TodoListFragment extends BaseFragment {

    private RecyclerView mRvTodo;
    private TodoListAdapter todoListAdapter;

    public static TodoListFragment newInstance() {
        TodoListFragment fragment = new TodoListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_todo_list;
    }

    @Override
    protected void initView(View view) {
        mRvTodo = view.findViewById(R.id.rv_todo);
        initRecyclerView();
        initDb();
        refreshData();
    }

    private void initRecyclerView() {
        todoListAdapter = new TodoListAdapter();
        mRvTodo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvTodo.setAdapter(todoListAdapter);
    }

    private void refreshData() {
        TodoListModel model = new TodoListModel();
        List<TodoBean> todoBeans = model.queryAll();
        todoListAdapter.setList(todoBeans);
    }

    private void initDb() {
        TodoListModel model = new TodoListModel();
        model.insertOrReplace(new TodoBean("1", "nihao"));
    }


}
