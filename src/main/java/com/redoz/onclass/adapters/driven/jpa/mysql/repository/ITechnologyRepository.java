package com.redoz.onclass.adapters.driven.jpa.mysql.repository;

import com.redoz.onclass.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long>{
    Optional<TechnologyEntity> findByName(String name);
}
