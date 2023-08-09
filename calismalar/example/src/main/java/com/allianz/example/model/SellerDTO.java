package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String shopName;
}
