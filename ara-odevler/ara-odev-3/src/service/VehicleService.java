package service;

import model.Accident;
import model.ColorTypeEnum;
import model.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VehicleService {
    public Vehicle createVehicle(String brand, String model, String plate,
                                 String chassisNumber, int modelYear, ColorTypeEnum color) {
        Vehicle vehicle = new Vehicle(brand, model, plate, chassisNumber, modelYear, color);
        return vehicle;
    }

    public void addAccidentToVehicle(Vehicle vehicle, Accident accident){
        if(vehicle.getAccidentList() == null)
            vehicle.setAccidentList(new ArrayList<>());

        vehicle.getAccidentList().add(accident);
    }

    public BigDecimal getTotalAccidentDamagePrice(Vehicle vehicle){
        BigDecimal totalAccidentDamage = BigDecimal.ZERO;
        for(Accident accident : vehicle.getAccidentList()){
            totalAccidentDamage = totalAccidentDamage.add(accident.getDamagePrice());
        }

        return totalAccidentDamage;
    }
}
