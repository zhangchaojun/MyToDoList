package com.example.mytodolist.ui.adapter;


import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.base.Constant;
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final TodoBean todoBean = list.get(position);
        int level = todoBean.getLevel();
        String content = todoBean.getContent();
        boolean isChecked = todoBean.isChecked();

        holder.tv_todo.setText(content);
        holder.iv_color.setBackground(getLevel(level));
        holder.checkbox.setChecked(isChecked);

        holder.tv_todo.getPaint().setFlags(isChecked ? Paint.STRIKE_THRU_TEXT_FLAG : 0);
        holder.tv_todo.getPaint().setAntiAlias(true);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                if (onItemClickListener != null) {
                    onItemClickListener.itemClicked(position);
                }
            }
        });

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

    public interface OnItemClickListener {
        void itemClicked(int positon);
    }

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private Drawable getLevel(int level) {
        Drawable drawable;
        switch (level) {
            case Constant.LEVEL1:
                drawable = context.getResources().getDrawable(R.drawable.shape_circle_level1);
                break;
            case Constant.LEVEL2:
                drawable = context.getResources().getDrawable(R.drawable.shape_circle_level2);
                break;
            case Constant.LEVEL3:
                drawable = context.getResources().getDrawable(R.drawable.shape_circle_level3);
                break;
            case Constant.LEVEL4:
                drawable = context.getResources().getDrawable(R.drawable.shape_circle_level4);
                break;
            default:
                drawable = context.getResources().getDrawable(R.drawable.shape_circle_level1);
        }
        return drawable;
    }
}
