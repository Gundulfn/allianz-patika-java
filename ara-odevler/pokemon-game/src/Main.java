import model.*;
import service.GameService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        Scanner scanner = new Scanner(System.in);

        VersusTypeEnum versusType = VersusTypeEnum.SOLO;

        if(versusType.equals(VersusTypeEnum.SOLO)){
            Player[] players = gameService.getCustomizedPlayers(2, scanner);

            System.out.print("Press any key to start solo game: ");
            if(scanner.hasNextLine()){
                scanner.nextLine();
                gameService.setRoundCount(2);
                gameService.playSoloGame(players, scanner);
            }
        }
    }
}