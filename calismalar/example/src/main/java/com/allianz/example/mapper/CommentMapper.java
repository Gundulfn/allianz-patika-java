package com.allianz.example.mapper;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper extends BaseMapper<CommentDTO, CommentEntity, CommentRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(CommentEntity.class, CommentDTO.class);
    }
}
