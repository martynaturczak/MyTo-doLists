package com.example.myto_dolists;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myto_dolists.R;
import com.example.myto_dolists.databinding.ItemTaskBinding;

public class TaskListAdapter extends ListAdapter<Exercise, TaskListAdapter.TaskViewHolder> {

    protected TaskListAdapter() {
        super(new DiffCallback());
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemTaskBinding binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        return new TaskViewHolder(binding);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Exercise task = getItem(position);
        holder.bind(task);
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView pointsTextView;
        private final TextView taskNameTextView;
        private final TextView taskContentTextView;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            pointsTextView = itemView.findViewById(R.id.pointsTextView);
            taskNameTextView = itemView.findViewById(R.id.taskNameTextView);
            taskContentTextView = itemView.findViewById(R.id.taskContentTextView);
        }

        void bind(Exercise task) {
           taskNameTextView.setText(task.content);
           pointsTextView.setText("Points: " + task.points);
        }
    }

    private static class DiffCallback extends DiffUtil.ItemCallback<Exercise> {
        @Override
        public boolean areItemsTheSame(@NonNull Exercise oldItem, @NonNull Exercise newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Exercise oldItem, @NonNull Exercise newItem) {
            return oldItem.content.equals(newItem.content) && oldItem.points == newItem.points;
        }
    }
}