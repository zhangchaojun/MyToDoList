package com.example.mytodolist.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.greendao.entity.TodoBean;
import com.example.mytodolist.R;

import java.util.List;

/**
 * Created by cj on 2020/12/7.
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {

    private List<TodoBean> list;
    private Context context;

    public TodoListAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<TodoBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TodoBean todoBean = list.get(position);
        holder.tv_todo.setText(todoBean.getContent());
        holder.iv_color.setBackground(context.getResources().getDrawable(R.drawable.shape_circle_level1));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_todo;
        ImageView iv_color;
        CheckBox checkbox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_todo = itemView.findViewById(R.id.tv_todo);
            iv_color = itemView.findViewById(R.id.iv_color);
            checkbox = itemView.findViewById(R.id.checkbox);

        }
    }
}
