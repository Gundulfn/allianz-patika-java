package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private Double rate;
}
