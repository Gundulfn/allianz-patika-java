package service;


import java.math.BigDecimal;
import java.util.*;

import model.CurrencyEnum;
import model.Player;
import model.Team;

public class PlayerService {
    public Player createPlayer(String name, String surname, int kitNumber, String position,
                               int birthYear, Team team, BigDecimal value, CurrencyEnum currency) {

        Player player = new Player(name, surname, kitNumber, position, birthYear, value, currency);
        addTeamToPlayer(player, team);

        return player;
    }

    public void addTeamToPlayer(Player player, Team team) {
        if (player.getTeamList() != null) {
            player.getTeamList().add(team);
        } else {
            List<Team> teamList = new ArrayList<>();
            teamList.add(team);
            player.setTeamList(teamList);
        }
    }
}