package com.lms.Helper.ResultHelper;

public class GradeCheck {

    public static String checkGrade(float marks) {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else if (marks >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public static boolean checkPass(float marks) {
        return marks >= 40;
    }
}
