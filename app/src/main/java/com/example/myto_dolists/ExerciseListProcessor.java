package com.example.myto_dolists;

import java.util.ArrayList;
import java.util.List;
public class ExerciseListProcessor {

    public static List<SubjectSummary> processExerciseLists(List<ExerciseList> exerciseLists) {
        List<SubjectSummary> subjectSummaries = new ArrayList<>();

        for (ExerciseList exerciseList : exerciseLists) {
            String subjectName = exerciseList.getSubject();
            double grade = exerciseList.getGrade();

            SubjectSummary existingSummary = findSubjectSummary(subjectSummaries, subjectName);

            if (existingSummary != null) {
                existingSummary.incrementListCount();
                existingSummary.addToTotalGrade(grade);
            }
            else {
                SubjectSummary newSummary = new SubjectSummary(subjectName, 1, grade);
                subjectSummaries.add(newSummary);
            }
        }

        return subjectSummaries;
    }
    private static SubjectSummary findSubjectSummary(List<SubjectSummary> summaries, String subjectName) {
        for (SubjectSummary summary : summaries) {
            if (summary.getSubjectName().equals(subjectName)) {
                return summary;
            }
        }
        return null;
    }
    public static class SubjectSummary {
        private String subjectName;
        private int listCount;
        private double totalGrade;

        public SubjectSummary(String subjectName, int listCount, double totalGrade) {
            this.subjectName = subjectName;
            this.listCount = listCount;
            this.totalGrade = totalGrade;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public int getListCount() {
            return listCount;
        }

        public void incrementListCount() {
            this.listCount++;
        }

        public double getTotalGrade() {
            return totalGrade;
        }

        public void addToTotalGrade(double grade) {
            this.totalGrade += grade;
        }
    }
}
