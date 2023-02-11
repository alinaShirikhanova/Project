package com.company.model;

import java.util.ArrayList;

public class AcademicPerformance {
    private int id;
    private int mark;
    private CourseEnrollment courseEnrollment;

    private static int lastID = 0;
    private static ArrayList<AcademicPerformance> list = new ArrayList<>();

    public AcademicPerformance(CourseEnrollment courseEnrollment, int mark){
        this.courseEnrollment = courseEnrollment;
        setMark(mark);
        list.add(this);
    }
    public AcademicPerformance(Student student, Course course, int mark){
        this(CourseEnrollment.getCourseEnrollment(student, course), mark);
    }

    public void setMark(int mark){
        if (mark < 1) mark = 1;
        if (mark > 100) mark = 100;
        this.mark = mark;
    }

    public static ArrayList<Integer> getMarksByStudentAndCourse(Student student, Course course){
        ArrayList<Integer> marks = new ArrayList<>();
        CourseEnrollment ce = CourseEnrollment.getCourseEnrollment(student, course);
        for (AcademicPerformance ap : list)
            if (ce == ap.courseEnrollment)
                marks.add(ap.mark);

        return marks;
    }

}
