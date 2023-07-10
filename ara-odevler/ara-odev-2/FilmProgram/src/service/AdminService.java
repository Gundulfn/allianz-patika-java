package service;

import java.util.*;
import filmmanagement.*;

public class AdminService {

    // To organize all Category and Platform instances
    private static List<Category> categories = new ArrayList<>();
    private static List<Platform> platforms = new ArrayList<>();

    public static boolean isPlatformExists(String platformName) {
        for (Platform platform : platforms) {
            if (platform.getName().equals(platformName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCategoryExists(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<Platform> getPlatforms() {
        return platforms;
    }

    // String: film name, to stop entering same film as new Film object
    private static Map<String, Film> films = new HashMap();

    public static Map<String, Film> getFilms() {
        return films;
    }

    private static String[] adminOperationTypeArray = { "Initialization Database" };
    private static int currentOperationId;

    public static void openAdminUI(Scanner scan, String input) {
        System.out.println("Welcome admin");
        for (int i = 0; i < adminOperationTypeArray.length; i++) {
            System.out.println(i + " - " + adminOperationTypeArray[i]);
        }

        currentOperationId = -1;
        while (currentOperationId < 0 || currentOperationId >= adminOperationTypeArray.length) {
            System.out.print("Select operation(type number of operation): ");

            if (scan.hasNextInt()) {
                currentOperationId = scan.nextInt();

                if (currentOperationId < 0 || currentOperationId >= adminOperationTypeArray.length) {
                    System.out.println("ERROR: Entered operation number is incorrect");
                    currentOperationId = -1;
                }
            } else {
                System.out.println("ERROR! Please enter a number");
            }

            scan.nextLine(); // set scanner to read new line
        }

        if (currentOperationId == 0) {
            // Platform inputs
            input = ""; // input resetting
            while (!input.equals("n")) {
                System.out.print("Please enter a platform: ");
                input = scan.nextLine();

                if (!isPlatformExists(input)) {
                    platforms.add(new Platform(input));
                } else {
                    System.out.println("This platform already exists");
                }

                System.out.print("Do you want to enter another platform(type 'n' to stop): ");
                input = scan.nextLine();
            }

            // Category inputs
            input = ""; // input resetting
            while (!input.equals("n")) {
                System.out.print("Please enter a category: ");
                input = scan.nextLine();

                if (!isCategoryExists(input)) {
                    categories.add(new Category(input));
                } else {
                    System.out.println("This category already exists");
                }

                System.out.print("Do you want to enter another category(type 'n' to stop): ");
                input = scan.nextLine();
            }

            // Film inputs
            input = ""; // input resetting
            while (!input.equals("n")) {
                Film film = new Film();

                System.out.print("Please enter a film name: ");
                String filmName = scan.nextLine();
                film.setFilmName(filmName);

                int publishYear = -1;
                while (publishYear < 0) {

                    System.out.print("Please enter the film's publish year: ");

                    if (scan.hasNextInt()) {
                        publishYear = scan.nextInt();
                        film.setPublishYear(publishYear);
                    } else {
                        System.out.println("ERROR! Please enter a number");
                    }

                    scan.nextLine(); // set scanner to read new line
                }

                System.out.print("Please enter the film's director: ");
                String director = scan.nextLine();
                film.setDirector(director);

                double imdb = -1;
                while (imdb < 0) {

                    System.out.print("Please enter the film's IMDB: ");

                    if (scan.hasNextDouble()) {
                        imdb = scan.nextDouble();
                        film.setImdb(imdb);
                    } else {
                        System.out.println("ERROR! Please enter a number");
                    }

                    scan.nextLine(); // set scanner to read new line
                }

                System.out.print("Please enter the film's duration: ");
                String duration = scan.nextLine();
                film.setDuration(duration);

                input = ""; // To start adding categories of current film
                while (!input.equals("n")) {

                    for (int i = 0; i < categories.size(); i++) {
                        System.out.println(i + " - " + categories.get(i).getName());
                    }

                    int categoryId = -1;
                    while (categoryId < 0) {
                        System.out.print("Please add the film's category(type number of category): ");

                        if (scan.hasNextInt()) {
                            categoryId = scan.nextInt();

                            if (categoryId >= 0 && categoryId < categories.size()) {
                                film.addCategoryToCategoryList(categories.get(categoryId));
                                categories.get(categoryId).increaseFilmCount();
                            } else {
                                System.out.println("ERROR: Entered category number is incorrect");
                                categoryId = -1;
                            }
                        } else {
                            System.out.println("ERROR! Please enter a number");
                        }

                        scan.nextLine(); // set scanner to read new line
                    }

                    System.out.print("Do you want to add another category of film(type 'n' to stop): ");
                    input = scan.nextLine();
                }

                input = ""; // To start adding platforms of current film
                while (!input.equals("n")) {

                    for (int i = 0; i < platforms.size(); i++) {
                        System.out.println(i + " - " + platforms.get(i).getName());
                    }

                    int platformId = -1;
                    while (platformId < 0) {
                        System.out.print("Please add the film's platform(type number of platform): ");

                        if (scan.hasNextInt()) {
                            platformId = scan.nextInt();

                            if (platformId >= 0 && platformId < platforms.size()) {
                                film.addPlatformToPlatformList(platforms.get(platformId));
                            } else {
                                System.out.println("ERROR: Entered platform number is incorrect");
                                platformId = -1;
                            }
                        } else {
                            System.out.println("ERROR! Please enter a number");
                        }

                        scan.nextLine(); // set scanner to read new line
                    }

                    System.out.print("Do you want to add another platform of film(type 'n' to stop): ");
                    input = scan.nextLine();
                }

                input = ""; // To start adding show times of current film
                while (!input.equals("n")) {

                    System.out.print("Please add the film's show time: ");
                    input = scan.nextLine();

                    film.addShowTimeToShowTimeList(input);

                    System.out.print("Do you want to add show time of film(type 'n' to stop): ");
                    input = scan.nextLine();
                }

                films.put(filmName, film);
                System.out.print("Do you want to enter another film(type 'n' to stop): ");
                input = scan.nextLine();
            }

            for (Category category : categories) {
                System.out.println(
                        "Total film entered for '"
                                + category.getName() + "' category: "
                                + category.getFilmCount());
            }

            // To move client side view
            System.out.print("Do you wish to change your view to client view(type 'y' to change): ");
            input = scan.nextLine();

            if (input.equals("y")) {
                ClientService.openClientUI(scan, input);
            }
        }
    }
}
