package com.burakcanciftci.erpweekeight.util.dbutil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public abstract interface IBaseEntityRepository<T, ID> extends JpaRepository<T, ID> {
    Optional<T> findByUuid(UUID uuid);

    @Modifying
    void deleteByUuid(UUID uuid);
}
