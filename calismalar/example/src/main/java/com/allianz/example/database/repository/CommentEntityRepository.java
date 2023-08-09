package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentEntityRepository extends IBaseRepository<CommentEntity, Long> {

}
