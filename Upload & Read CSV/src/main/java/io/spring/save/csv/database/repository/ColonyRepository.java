package io.spring.save.csv.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.spring.save.csv.database.entity.Colony;

public interface ColonyRepository extends JpaRepository<Colony, Long>{

}
