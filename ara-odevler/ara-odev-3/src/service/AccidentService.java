package service;

import model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {
    public Accident createAccident(Date accidentDate, String description, BigDecimal damagePrice, int failureRate){
        Accident accident = new Accident(accidentDate, description, damagePrice, failureRate);
        return accident;
    }
}