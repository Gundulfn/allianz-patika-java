package util;

public class GradeTest {
    public void printGradeValues() {
        for (Grade g : Grade.values()) {
            System.out.println(g.toString());
        }
        System.out.println();
    }
}