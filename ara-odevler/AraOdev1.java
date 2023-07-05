import java.util.*;

public class AraOdev1 {
    public static void main(String[] args) {
        Map<String, List<String>> studentsOfClassrooms = new HashMap<>();

        // Let's say there are three classroom like: 1-A, 1-B and 1-C
        // Defining 1-A classroom students
        List<String> studentsOfClassroom1A = new ArrayList<>();
        studentsOfClassroom1A.add("Burak Can Çiftçi");
        studentsOfClassroom1A.add("Faruk Yıldız");

        studentsOfClassrooms.put("1-A", studentsOfClassroom1A);

        // Defining 1-B classroom students
        List<String> studentsOfClassroom1B = new ArrayList<>();
        studentsOfClassroom1B.add("Ayşe Yıldırım");
        studentsOfClassroom1B.add("Osman Karaman");
        studentsOfClassroom1B.add("Kazım Fuat Kılıç");

        studentsOfClassrooms.put("1-B", studentsOfClassroom1B);

        // Defining 1-C classroom students
        List<String> studentsOfClassroom1C = new ArrayList<>();
        studentsOfClassroom1C.add("Ahmet Hasan İhsan Toprak");
        studentsOfClassroom1C.add("Leyla Gümüş");
        studentsOfClassroom1C.add("Hatice Neslihan Işık");
        studentsOfClassroom1C.add("Emirhan Güngör");

        studentsOfClassrooms.put("1-C", studentsOfClassroom1C);

        /**
         * Dummy @param: splitStudentNameParts and @param: students
         * created for searching students' who name ends with "an"
         * at @param 'studentsOfClassrooms'
         */
        String[] splitStudentNameParts;
        List<String> students = new ArrayList<>();
        for (String key : studentsOfClassrooms.keySet()) {
            students = studentsOfClassrooms.get(key);

            for (String student : students) {
                splitStudentNameParts = student.split(" ");

                // splitStudentNameParts.length - 2 is name index
                if (splitStudentNameParts[splitStudentNameParts.length - 2].endsWith("an")) {
                    System.out.println("Student " + student + " is from " + key + " class.");
                }
            }
        }
    }
}
