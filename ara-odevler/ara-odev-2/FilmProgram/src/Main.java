import service.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        while (!input.equals("c") || !input.equals("a")) {
            System.out.print("Are you client/admin(type 'c' or 'a'): ");
            input = scan.nextLine();

            if (input.equals("a")) {
                AdminService.openAdminUI(scan, input);
            } else if (input.equals("c")) {
                ClientService.openClientUI(scan, input);
            } else {
                System.out.println("ERROR: Incorrect input");
            }
        }
    }
}