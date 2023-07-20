package main.transcript;

import util.Grade;

import java.util.ArrayList;
import java.util.List;

public class CourseGrade {
    private CourseDepartment courseDepartment;
    private final CourseDepartment DEFAULT_COURSE_DEPARTMENT = CourseDepartment.CENG;

    private int courseCode;
    private final static int DEFAULT_COURSE_CODE = 100;
    private final static int LOWER_COURSE_CODE_BOUND = 100;
    private final static int UPPER_COURSE_CODE_BOUND = 599;

    private int courseCredit;
    private final static int DEFAULT_COURSE_CREDIT = 4;
    private final static List<Integer> VALID_COURSE_CREDIT_LIST = new ArrayList<>() {{
        add(3);
        add(DEFAULT_COURSE_CREDIT);
    }};

    private Grade gradeTaken;
    private final static Grade DEFAULT_GRADE_TAKEN = Grade.F;

    // Constructors
    public CourseGrade(CourseDepartment courseDepartment) {
        this(courseDepartment, DEFAULT_COURSE_CODE, DEFAULT_COURSE_CREDIT, DEFAULT_GRADE_TAKEN);
    }

    public CourseGrade(CourseDepartment courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, DEFAULT_COURSE_CREDIT, DEFAULT_GRADE_TAKEN);
    }

    public CourseGrade(CourseDepartment courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, DEFAULT_GRADE_TAKEN);
    }

    public CourseGrade(CourseDepartment courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        this.setCourseDepartment(courseDepartment);
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setGradeTaken(gradeTaken);
    }

    // Getter-Setter methods
    public CourseDepartment getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(CourseDepartment courseDepartment) {
        if (courseDepartment != null) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = DEFAULT_COURSE_DEPARTMENT;
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= LOWER_COURSE_CODE_BOUND && courseCode <= UPPER_COURSE_CODE_BOUND) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = DEFAULT_COURSE_CODE;
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    /**
     * Check if parameter is valid by VALID_COURSE_CREDIT_LIST,
     * otherwise this.courseCredit will be default value
     *
     * @param courseCredit
     */
    public void setCourseCredit(int courseCredit) {
        if (VALID_COURSE_CREDIT_LIST.contains(courseCredit)) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = DEFAULT_COURSE_CREDIT;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(Grade gradeTaken) {
        if (gradeTaken != null) {
            this.gradeTaken = gradeTaken;
        } else {
            this.gradeTaken = DEFAULT_GRADE_TAKEN;
        }
    }

    public void setGradeTaken(double val) {
        int numericValue = (int) Math.round(val);
        gradeTaken = DEFAULT_GRADE_TAKEN;

        for (Grade grade : Grade.values()) {
            if (grade.numericValue == numericValue) {
                gradeTaken = grade;
            }
        }
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment +
                " Code: " + courseCode +
                " Credit: " + courseCredit +
                " Grade: " + gradeTaken.stringValue;
    }
}