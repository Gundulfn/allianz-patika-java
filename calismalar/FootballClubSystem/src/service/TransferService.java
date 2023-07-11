package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TransferService {
    public void makeTransfer(Player player, Team toTeam) {
        BigDecimal convertedPlayerValueAsToTeamCurrency =
                CurrencyEnum.convertCurrencies(player.getValue(), player.getCurrency(), toTeam.getCurrency());
        int isPlayerTransferable = toTeam.getBudget().compareTo(convertedPlayerValueAsToTeamCurrency);

        if (isPlayerTransferable >= 0) {
            System.out.println("Transferring process started");
            toTeam.setBudget(toTeam.getBudget().subtract(convertedPlayerValueAsToTeamCurrency));

            Team fromTeam = player.getTeamList().get(player.getTeamList().size() - 1);

            BigDecimal convertedPlayerValueAsFromTeamCurrency =
                    CurrencyEnum.convertCurrencies(player.getValue(), player.getCurrency(), fromTeam.getCurrency());
            fromTeam.setBudget(fromTeam.getBudget().add(convertedPlayerValueAsFromTeamCurrency));

            addTranferToPlayerTransferHistory(player, fromTeam, toTeam, 2023);

        } else {
            System.out.println("Cannot transfer player, low budget");
        }
    }

    public void addTranferToPlayerTransferHistory(Player player, Team fromTeam, Team toTeam, int transferYear) {
        Transfer transfer = new Transfer(fromTeam, toTeam, transferYear, player.getValue(), player.getCurrency());

        if (player.getTransferHistory() != null) {
            player.getTransferHistory().add(transfer);
        } else {
            player.setTransferHistory(new ArrayList<>());
            player.getTransferHistory().add(transfer);
        }
    }
}