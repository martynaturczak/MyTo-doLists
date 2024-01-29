package com.example.myto_dolists;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.myto_dolists.databinding.FragmentE2Binding;
import java.util.List;
import androidx.lifecycle.ViewModelProvider;

public class FragmentE2 extends Fragment {
    private FragmentE2Binding binding;
    private GradeListAdapter gradeListAdapter;
    ViewModel1 viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentE2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gradeListAdapter = new GradeListAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(gradeListAdapter);
        viewModel = new ViewModelProvider(requireActivity()).get(ViewModel1.class);
        List<ExerciseList> exerciseLists = viewModel.getExerciseLists();
//        displayGrades(exerciseLists);

        List<ExerciseListProcessor.SubjectSummary> subjectSummaries = ExerciseListProcessor.processExerciseLists(exerciseLists);
        gradeListAdapter.submitList(subjectSummaries);
    }
//    private void displayGrades(List<ExerciseList> exerciseLists) {
//        gradeListAdapter.submitList(exerciseLists);
//    }
}