package com.allianz.example.controller;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.mapper.CommentMapper;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.service.CommentService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController extends BaseController<CommentEntity, CommentRequestDTO, CommentDTO> {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentMapper commentMapper;
}
