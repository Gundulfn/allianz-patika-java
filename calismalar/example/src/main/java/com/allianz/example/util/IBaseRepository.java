package com.allianz.example.util;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<T, ID> extends JpaRepository<T, ID> {
    Optional<T> findByUuid(UUID uuid);

    @Transactional
    void deleteByUuid(UUID uuid);
}
