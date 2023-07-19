package service;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalRoundService {
    public static BigDecimal round(BigDecimal value){
        return value.round(new MathContext(3));
    }
}
