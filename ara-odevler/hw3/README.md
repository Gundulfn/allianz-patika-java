# Homework 3: Transcript Generator 
This project is generating transcripts of students from course grades they got. Program's scripts are oorganized in two packages:
- main: This package contains the main classes that perform the generation of transcripts(These scripts are under transcript package) and simulate program's interface.
- util: This package contains the utility classes which are used in the application.

Scripts are defined according to these statements:

## 1. Grade(Enum)
- The enum type Grade represents the grade of a student and it should define constants representing the grades of A, B, C, D, F.
- The constants should be named Grade.A, Grade.B, Grade.C, Grade.D, Grade.F.
- Grade should have two instance fields, stringValue and numericValue.
- stringValue should contain a String representation of the letter grade, e.g., “C”, “A”.
numericValue should contain the numeric grade corresponding to the letter grade, which
are 4, 3, 2, 1, 0 for A, B, C, D, and F respectively.
- Implement an appropriate toString() method for this class that will print the letter and
numerical grade stored for a grade as in the following form (for Grade.F): Grade F corresponds to numeric grade 0

## 2. GradeTest(Class)
- In the package, hw3.util, write a test program GradeTest that uses the enhanced for loop, and the values() method of Grade to print out the following output:
```
     Grade F corresponds to numeric grade 0.
     Grade D corresponds to numeric grade 1.
     .
     .
     .
     Grade A corresponds to numeric grade of 4.
```
- Use toString() method of Grade class during printing.
  
## 3. CourseGrade(Class)
- The CourseGrade class will keep information about the department the course is offered, course code of the course, credit of the course and the grade taken for that course in the courseDepartment, courseCode and courseCredit and gradeTaken fields.
- courseDepartment is a four letter acronym indicating the department, the class is offered.
- The possible values of departments in your application are CENG, COMP, ECE, ME and MATH(For this, CourseDepartment(Enum) is created and set).
 courseCode is a three digit code (e.g., 101, 200, or 590) for the course. This number should
be between 100 and 599.
- courseCredit is an integer that indicates how many credits the course is worth. The only
valid values are 3 and 4.
- gradeTaken is a Grade value that represents the grade obtained in this course.
- Provide all appropriate get and set methods for the fields above. Set methods should perform a
check on their arguments and set the field to a default value if the argument to the set method
is invalid.
- Default values for courseCode is 100, courseCredit is 4, courseDepartment is CENG
andgradeTaken isGrade.F.
- The set method for gradeTaken should be overloaded as specified below:
  - setGradeTaken(double val) should select the letter grade whose numeric value is closest to val if numValue is between 0 and 4.0 . Otherwise it should set gradeTaken to Grade.F
  - setGradeTaken (Grade g) should simply set the grade to the value given by g
- Implement four overloaded constructors which will take either
  - only courseDepartment
  - courseDepartment and courseCode
  - courseDepartment,courseCode and courseCredit
  - courseDepartment, courseCode, courseCredit, and gradeTaken
  as input. They will fill in the missing parameters for the fields to the default values mentioned in item 8.
- The first, second and third constructor will call the fourth constructor and that constructor should set all the fields using the set method of those variables.
- Implement a toString() method for this class that will return a string value that contains all the information stored for a CourseGrade object in the following form:
```
Department: CENG CourseCode: 201 Credit: 5 Grade: F
```

## 4. Transcript(Class)
- This class keeps the transcript of a student with id studentID.
- studentID is an integer value storing the id of the student. 
- Each student transcript can contain grades of arbitrary number of courses, therefore, the class keeps an arbitrary number of CourseGrade objects that stands for the grades taken by the student throughout her education. Therefore, you should include an appropriate field in the class to keep these arbitrary number of CourseGrade objects.
- The class also calculates and stores the GPA of the student as a double field which is the average of all grades taken by the student for all the courses. GPA is therefore a value between 0.0 and 4.0.
- Class has a one-argument constructor that takes an integer containing the student’s id ,sets GPA to 0.0 and initializes the list of CourseGrade objects.
- It has an addCourseTaken method which will take a CourseGrade object as input and inserts it into the list of course grades stored in the Transcript. This method should first check that CourseGrade object given as parameter is not null. Otherwise, it should not perform the addition and print an error message. In addition, it should update the GPA of the student accordingly.
- The class should have a toString()method that prints the student’s transcript. This method should use the toString()method of CourseGrade class. The student’s GPA together with each of the course grades should be printed in the following form.
```
  Student ID: 1112234
   Department: CENG Code: 201 Credit: 5 Grade: C
   Department: CENG Code: 201 Credit: 5 Grade: A
   Department: CENG Code: 201 Credit: 5 Grade: C
   Department: CENG Code: 201 Credit: 5 Grade: A
   Department: CENG Code: 201 Credit: 5 Grade: B
   GPA:3.0
  ```
