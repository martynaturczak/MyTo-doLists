package com.example.myto_dolists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import com.example.myto_dolists.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import androidx.lifecycle.ViewModelProvider;
public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private ActivityMainBinding binding;
    ViewModel1 viewModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        viewModel1 = new ViewModelProvider(this).get(ViewModel1.class);
        List<ExerciseList> exerciseLists = DataGeneration.generateExerciseLists();
        viewModel1.setExerciseLists(exerciseLists);
    }
}



