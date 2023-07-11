import model.*;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();

        Team team1 = teamService.createTeam("Galatasaray", "GS", "yellow-red", "Okan Buruk",
                "Dursun Özbek", "Nef Arena", new BigDecimal(1000000), CurrencyEnum.TL, "Türkiye");

        teamService.addAwardToTeam(team1, "Champions Cup", 2023, AwardTypeEnum.CUP, AwardCategoryEnum.INTERNATIONAL);
        teamService.addAwardToTeam(team1, "League Cup", 2023, AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        System.out.println(team1.toString());

        Player player = playerService.createPlayer("Burak", "Yılmaz", 1, "Forvette", 1997,
                                                       team1, new BigDecimal(150000), CurrencyEnum.EUR);

        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue", "İsmail Kartal",
                "Ali Koç", "Kadıköy", new BigDecimal(1000000), CurrencyEnum.USD, "Türkiye");

        teamService.addAwardToTeam(team2, "Champions Cup", 2023, AwardTypeEnum.CUP, AwardCategoryEnum.INTERNATIONAL);

        transferService.makeTransfer(player, team2);
        System.out.println(team1);
        System.out.println(team2);
        System.out.println(player);
    }
}