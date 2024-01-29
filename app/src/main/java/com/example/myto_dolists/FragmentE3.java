package com.example.myto_dolists;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myto_dolists.databinding.FragmentE1Binding;
import com.example.myto_dolists.databinding.FragmentE3Binding;
import java.util.List;
public class FragmentE3 extends Fragment {
    private FragmentE3Binding binding;
    private TaskListAdapter taskListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentE3Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskListAdapter = new TaskListAdapter();

        binding.tasksRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.tasksRecyclerView.setAdapter(taskListAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ExerciseList selectedExerciseList = bundle.getParcelable("selectedExerciseList");
            if (selectedExerciseList != null) {
                // Wyświetl zadania dla wybranej listy
                displayTasks(selectedExerciseList);
            }
        }
    }

    private void displayTasks(ExerciseList exerciseList) {
        taskListAdapter.submitList(exerciseList.exercises);
    }
}