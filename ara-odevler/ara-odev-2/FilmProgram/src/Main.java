import filmmanagement.*;
import java.util.*;

public class Main {
    // To organize all Category and Platform instances
    static List<Category> categories = new ArrayList<>();
    static List<Platform> platforms = new ArrayList<>();

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

    // String: film name, to stop entering same film as new Film object
    static Map<String, Film> films = new HashMap();
    static String[] adminOperationTypeArray = {"Initialization Database"};
    static String[] clientOperationTypeArray = {"Select New Category"};

    public static void openClientUI(Scanner scan, String input) {
        System.out.println("Welcome to the Java Cinema Platform!");

        input = "";
        while (!input.equals("n")) {
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(i + " - " + categories.get(i).getName());
            }

            System.out.print("Please select a category of films(type number of category): ");
            int categoryNum = scan.nextInt();

            if (categoryNum >= 0 && categoryNum < categories.size()) {
                // Detect if film's categories match with client category selection
                for (Film film : films.values()) {
                    if (film.getCategoryList().contains(categories.get(categoryNum))) {
                        System.out.println("- " + film.toString());
                    }
                }
            } else {
                System.out.println("ERROR: Entered category number is incorrect");
            }

            scan.nextLine();
            for (int i = 0; i < clientOperationTypeArray.length; i++) {
                System.out.println(i + " - " + clientOperationTypeArray[i]);
            }

            System.out.print("Select operation(type number of operation): ");
            input = scan.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print("Are you client/admin(type 'c' or 'a'): ");
        input = scan.nextLine();

        if (input.equals("a")) {
            System.out.println("Welcome admin");
            for (int i = 0; i < adminOperationTypeArray.length; i++) {
                System.out.println(i + " - " + adminOperationTypeArray[i]);
            }

            System.out.print("Select operation(type number of operation): ");
            input = scan.nextLine();

            if (input.equals("0")) {
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

                    System.out.print("Please enter the film's publish year: ");
                    int publishYear = scan.nextInt();
                    film.setPublishYear(publishYear);
                    scan.nextLine(); // set scanner to read new line

                    System.out.print("Please enter the film's director: ");
                    String director = scan.nextLine();
                    film.setDirector(director);

                    System.out.print("Please enter the film's IMDB: ");
                    double imdb = scan.nextDouble();
                    film.setImdb(imdb);
                    scan.nextLine(); // set scanner to read new line

                    System.out.print("Please enter the film's duration: ");
                    String duration = scan.nextLine();
                    film.setDuration(duration);

                    input = ""; // To start adding categories of current film
                    while (!input.equals("n")) {

                        for (int i = 0; i < categories.size(); i++) {
                            System.out.println(i + " - " + categories.get(i).getName());
                        }

                        System.out.print("Please add the film's category(type number of category): ");
                        int categoryNum = scan.nextInt();

                        if (categoryNum >= 0 && categoryNum < categories.size()) {
                            film.addCategoryToCategoryList(categories.get(categoryNum));
                            categories.get(categoryNum).increaseFilmCount();
                        } else {
                            System.out.println("ERROR: Entered category number is incorrect");
                        }

                        scan.nextLine(); // set scanner to read new line
                        System.out.print("Do you want to add another category of film(type 'n' to stop): ");
                        input = scan.nextLine();
                    }

                    input = ""; // To start adding platforms of current film
                    while (!input.equals("n")) {

                        for (int i = 0; i < platforms.size(); i++) {
                            System.out.println(i + " - " + platforms.get(i).getName());
                        }

                        System.out.print("Please add the film's platform(type number of platfom): ");
                        int platformNum = scan.nextInt();

                        if (platformNum >= 0 && platformNum < platforms.size()) {
                            film.addPlatformToPlatformList(platforms.get(platformNum));
                        } else {
                            System.out.println("ERROR: Entered platform number is incorrect");
                        }

                        scan.nextLine(); // set scanner to read new line
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

                System.out.println(films.values().toString());

                // To move client side view
                System.out.print("Do you wish to change your view to client view(type 'y' to change): ");
                input = scan.nextLine();
                if (input.equals("y")) {
                    openClientUI(scan, input);
                }
            }
        } else if (input.equals("c")) {
            openClientUI(scan, input);
        } else {
            System.out.println("ERROR: Incorrect input");
        }
    }
}