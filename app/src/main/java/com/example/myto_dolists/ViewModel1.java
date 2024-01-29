package com.example.myto_dolists;

import androidx.lifecycle.ViewModel;
import java.util.List;

public class ViewModel1 extends ViewModel {
    private List<ExerciseList> exerciseLists;

    public List<ExerciseList> getExerciseLists() {
        return exerciseLists;
    }

    public void setExerciseLists(List<ExerciseList> exerciseLists) {
        this.exerciseLists = exerciseLists;
    }
}
