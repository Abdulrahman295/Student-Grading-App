package main;

import main.app.StudentGradingApp;

public class Main {
    public static void main(String[] args) throws Exception {

        String inputPath = "src/test/black_box/resources/empty_data.txt";
        String outputPath = "src/main/file/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputPath, outputPath);

        app.calculateStudentsGrades();
    }
}