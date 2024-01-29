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
import com.example.myto_dolists.databinding.ItemExerciseListBinding;

public class ExerciseListAdapter extends ListAdapter<ExerciseList, ExerciseListAdapter.ExerciseListViewHolder> {
    private static final DiffUtil.ItemCallback<ExerciseList> diffCallback = new DiffCallback();
    private ExerciseListClickListener listener;

    protected ExerciseListAdapter() {
        super(diffCallback);
    }

    public void setExerciseListClickListener(ExerciseListClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_list, parent, false);
        return new ExerciseListViewHolder(view);
        //clickonlisteenr
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
        ExerciseList exerciseList = getItem(position);
        holder.bind(exerciseList, listener);
    }

    static class ExerciseListViewHolder extends RecyclerView.ViewHolder {
        private final TextView subjectTextView;
        private final TextView gradeTextView;
        private final TextView numberOfExercisesTextView;
        private final TextView listNumberTextView;

        ExerciseListViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
            gradeTextView = itemView.findViewById(R.id.gradeTextView);
            numberOfExercisesTextView = itemView.findViewById(R.id.numberOfExercisesTextView);
            listNumberTextView = itemView.findViewById(R.id.listNumberTextView);
        }

        void bind(ExerciseList exerciseList, ExerciseListClickListener listener) {
            subjectTextView.setText(exerciseList.subject.name);
            gradeTextView.setText("Ocena " + String.valueOf(exerciseList.getGrade()));
            numberOfExercisesTextView.setText("Liczba zadań " + String.valueOf(exerciseList.getNumberOfExercises()));
            listNumberTextView.setText("Lista");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(exerciseList);
                    }
                }
            });
        }
    }

    private static class DiffCallback extends DiffUtil.ItemCallback<ExerciseList> {
        @Override
        public boolean areItemsTheSame(@NonNull ExerciseList oldItem, @NonNull ExerciseList newItem) {
            return oldItem == newItem;
        }
        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ExerciseList oldItem, @NonNull ExerciseList newItem) {
            return oldItem.equals(newItem);
        }
    }

    public interface ExerciseListClickListener {
        void onItemClick(ExerciseList exerciseList);
    }
}