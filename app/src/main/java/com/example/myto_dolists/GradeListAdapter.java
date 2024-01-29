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
import java.text.DecimalFormat;
public class GradeListAdapter extends ListAdapter<ExerciseListProcessor.SubjectSummary, GradeListAdapter.GradeListViewHolder> {

    protected GradeListAdapter() {
        super(new DiffCallback());
    }

    @NonNull
    @Override
    public GradeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_list_second_fragment, parent, false);
        return new GradeListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeListViewHolder holder, int position) {
        ExerciseListProcessor.SubjectSummary subjectSummary = getItem(position);
        holder.bind(subjectSummary);
    }

    static class GradeListViewHolder extends RecyclerView.ViewHolder {
        private final TextView subjectNameTextView;
        private final TextView numberOfListsTextView;
        private final TextView meanTextView;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        GradeListViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectNameTextView = itemView.findViewById(R.id.subjectNameTextView);
            numberOfListsTextView = itemView.findViewById(R.id.numberOfListsTextView);
            meanTextView = itemView.findViewById(R.id.meanTextView);
        }

        void bind(ExerciseListProcessor.SubjectSummary subjectSummary) {
            subjectNameTextView.setText(subjectSummary.getSubjectName());
            numberOfListsTextView.setText("Liczba list: " + subjectSummary.getListCount());
            meanTextView.setText("Średnia: " + decimalFormat.format(subjectSummary.getTotalGrade() / subjectSummary.getListCount()));
        }
    }
private static class DiffCallback extends DiffUtil.ItemCallback<ExerciseListProcessor.SubjectSummary> {
    @Override
    public boolean areItemsTheSame(@NonNull ExerciseListProcessor.SubjectSummary oldItem, @NonNull ExerciseListProcessor.SubjectSummary newItem) {
        return oldItem.getSubjectName().equals(newItem.getSubjectName());
    }
    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull ExerciseListProcessor.SubjectSummary oldItem, @NonNull ExerciseListProcessor.SubjectSummary newItem) {
        return oldItem.equals(newItem);
    }
}
}
