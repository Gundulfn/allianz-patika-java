package service;

import java.util.List;
import java.util.Scanner;

public class UtilityService {
    public static <T> T selectElementFromList(List<T> list, Scanner scanner, String selectionText){
        int selectionID = -1;
        while (selectionID < 0 || selectionID >= list.size()) {
            for (int j = 0; j < list.size(); j++) {
                System.out.println((j + 1) + " - " + list.get(j));
            }

            System.out.print(selectionText);

            try {
                selectionID = scanner.nextInt() - 1;

                if(selectionID < 0 || selectionID >= list.size())
                    System.out.println("Number you entered is out of selection list range");

            }catch (Exception e){
                System.out.println("ERROR: Input must be an integer number");
            }finally {
                scanner.nextLine(); // Reset scanner's current reading line
            }
        }

        return list.get(selectionID);
    }
}