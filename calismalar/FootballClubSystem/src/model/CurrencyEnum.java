package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum CurrencyEnum {
    USD(new BigDecimal(29d)),
    EUR(new BigDecimal(30d)),
    TL(new BigDecimal(2d));
    public final BigDecimal UNIT_VALUE;
    private CurrencyEnum(BigDecimal unitValue){
        this.UNIT_VALUE = unitValue;
    }

    public static BigDecimal convertCurrencies(BigDecimal value, CurrencyEnum fromCurrency, CurrencyEnum toCurreny){
        // Adding @param scale and @param RoundingMode parameters to 'divide' function for handling rounding errors
        BigDecimal convertedValue =
                (value.multiply(fromCurrency.UNIT_VALUE))
                        .divide(toCurreny.UNIT_VALUE, 2, RoundingMode.HALF_UP);
        System.out.println("Currency Conversion: " + value.toString() + fromCurrency + " = " + convertedValue + toCurreny);
        return convertedValue;
    }
}