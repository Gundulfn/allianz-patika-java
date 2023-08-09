package com.allianz.example.model.requestDTO;

import com.allianz.example.model.CustomerDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class CommentRequestDTO extends BaseDTO {
    private CustomerDTO customer;
    private String comment;
}
