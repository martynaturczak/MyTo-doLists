package com.example.myto_dolists;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import com.example.myto_dolists.databinding.FragmentE1Binding;
import androidx.lifecycle.ViewModelProvider;

public class FragmentE1 extends Fragment {
    private FragmentE1Binding binding;
    private ExerciseListAdapter exerciseListAdapter;
    private ViewModel1 viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentE1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exerciseListAdapter = new ExerciseListAdapter();

        binding.recyclerView1.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView1.setAdapter(exerciseListAdapter);

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModel1.class);
        List<ExerciseList> exerciseLists = viewModel.getExerciseLists();
        exerciseListAdapter.submitList(exerciseLists);

        exerciseListAdapter.setExerciseListClickListener(new ExerciseListAdapter.ExerciseListClickListener() {
            @Override
            public void onItemClick(ExerciseList exerciseList) {
                openFragmentE3(exerciseList);
            }
        });
    }
    private void openFragmentE3(ExerciseList exerciseList) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedExerciseList", (Parcelable) exerciseList);
        // Użyj NavControllera do nawigacji do Fragmentu E3
        NavHostFragment.findNavController(this).navigate(R.id.action_fragmentE1_to_fragmentE3, bundle);
    }
//    private void openFragmentE3(ExerciseList exerciseList) {
//        FragmentE3 fragmentE3 = new FragmentE3();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("selectedExerciseList", (Parcelable) exerciseList);
//        fragmentE3.setArguments(bundle);

//        getParentFragmentManager().beginTransaction()
//                .replace(((ViewGroup)getView().getParent()).getId(), fragmentE3)
//                .addToBackStack(null)
//                .commit();
//        NavHostFragment.findNavController(this).navigate(R.id.action_fragmentE1_to_fragmentE3, bundle);
//    }
}
