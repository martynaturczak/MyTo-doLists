package com.example.myto_dolists;
import java.util.*;

class Exercise {
    String content;
    int points;
    Exercise(String content, int points) {
        this.content = content;
        this.points = points;
    }
}
class Subject {
    String name;
    Subject(String name)  {
        this.name = name;
    }
}
class ExerciseList {
    List<Exercise> exercises;
    Subject subject;
    double grade;

    ExerciseList(List<Exercise> exercises, Subject subject, double grade) {
        this.exercises = exercises;
        this.subject = subject;
        this.grade = grade;
    }
    public double getGrade(){
        return grade;
    }
    public String getSubject(){
        return subject.name;
    }
    public int getNumberOfExercises() {
        return exercises.size();
    }
}
public class DataGeneration {
    private static final String[] subjects = {"Matematyka", "PUM", "Fizyka", "Elektronika", "Algorytmy"};
    static Random rand = new Random();
    private static ExerciseList generateExerciseList() {
        Subject subject = new Subject(subjects[rand.nextInt(subjects.length)]);
        double grade = 3.0 + Math.floor(Math.random() * ((5.0 - 3.0) / 0.5 + 1)) * 0.5;
        List<Exercise> exercises = new ArrayList<>();
        int numberOfExercises = rand.nextInt(10) + 1;
        for(int i = 1; i <= numberOfExercises; i++) {
            int points = rand.nextInt(10) + 1;
            exercises.add(new Exercise("Treść zadania " + i, points));
        }
        return new ExerciseList(exercises, subject, grade);
    }
    public static List<ExerciseList> generateExerciseLists() {
        List<ExerciseList> exerciseLists = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            ExerciseList exerciseList = generateExerciseList();
            exerciseLists.add(exerciseList);
        }
        return exerciseLists;
    }
}
