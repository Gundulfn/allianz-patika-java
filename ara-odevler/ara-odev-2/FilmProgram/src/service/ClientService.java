package service;

import java.util.Scanner;
import filmmanagement.Film;

public class ClientService {
    private static String[] clientOperationTypeArray = { "Select A Film Category" };
    private static int currentOperationId;

    public static void openClientUI(Scanner scan, String input) {
        System.out.println("Welcome to the Java Cinema Platform!");

        input = "";
        while (!input.equals("n")) {

            for (int i = 0; i < clientOperationTypeArray.length; i++) {
                System.out.println(i + " - " + clientOperationTypeArray[i]);
            }

            currentOperationId = -1;
            while (currentOperationId < 0 || currentOperationId >= clientOperationTypeArray.length) {
                System.out.print("Select operation(type number of operation): ");

                if (scan.hasNextInt()) {
                    currentOperationId = scan.nextInt();

                    if (currentOperationId < 0 || currentOperationId >= clientOperationTypeArray.length) {
                        System.out.println("ERROR: Entered operation number is incorrect");
                        currentOperationId = -1;
                    }
                } else {
                    System.out.println("ERROR! Please enter a number");
                }

                scan.nextLine(); // set scanner to read new line
            }

            if (currentOperationId == 0) {
                for (int i = 0; i < AdminService.getCategories().size(); i++) {
                    System.out.println(i + " - " + AdminService.getCategories().get(i).getName());
                }

                int categoryId = -1;
                while (categoryId < 0) {
                    System.out.print("Please select a category of films(type number of category): ");

                    if (scan.hasNextInt()) {
                        categoryId = scan.nextInt();

                        if (categoryId >= 0 && categoryId < AdminService.getCategories().size()) {
                            // Detect if film's categories match with client category selection
                            for (Film film : AdminService.getFilms().values()) {
                                if (film.getCategoryList().contains(AdminService.getCategories().get(categoryId))) {
                                    System.out.println("- " + film.toString());
                                }
                            }
                        } else {
                            System.out.println("ERROR: Entered category number is incorrect");
                            categoryId = -1;
                        }
                    } else {
                        System.out.println("ERROR! Please enter a number");
                    }

                    scan.nextLine(); // set scanner to read new line
                }
            }
        }
    }
}
