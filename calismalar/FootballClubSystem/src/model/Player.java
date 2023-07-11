package model;

import java.util.*;
import java.math.BigDecimal;

public class Player {
    private String name;
    private String surname;
    private int kitNumber;
    private String position;
    private int birthYear;
    private BigDecimal value;
    private CurrencyEnum currency;
    private List<Transfer> transferHistory;
    private List<Team> teamList;

    public Player(String name, String surname, int kitNumber, String position,
                  int birthYear, BigDecimal value, CurrencyEnum currency) {
        this.name = name;
        this.surname = surname;
        this.kitNumber = kitNumber;
        this.position = position;
        this.birthYear = birthYear;
        this.value = value;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(int kitNumber) {
        this.kitNumber = kitNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }

    public void setTransferHistory(List<Transfer> transferHistory) {
        this.transferHistory = transferHistory;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", kitNumber=" + kitNumber +
                ", position='" + position + '\'' +
                ", birthYear=" + birthYear +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                ", transferHistory=" + transferHistory +
                ", teamList=" + teamList +
                '}';
    }
}