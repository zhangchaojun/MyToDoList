package com.example.mytodolist.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.mytodolist.R;
import com.example.mytodolist.ui.fragment.TodoListFragment;

public class MainActivity extends AppCompatActivity {

    private TodoListFragment todoListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListFragment = TodoListFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_container, todoListFragment);
        transaction.show(todoListFragment);
        transaction.commitAllowingStateLoss();


    }
}