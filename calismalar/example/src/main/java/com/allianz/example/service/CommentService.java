package com.allianz.example.service;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.repository.CommentEntityRepository;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseService<CommentEntity, CommentRequestDTO, CommentDTO> {

    private final CommentEntityRepository commentEntityRepository;

    public CommentService(CommentEntityRepository commentEntityRepository) {
        super(commentEntityRepository);
        this.commentEntityRepository = commentEntityRepository;
    }

}
