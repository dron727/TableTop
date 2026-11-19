package org.example.restreservation.repository;

import org.example.restreservation.entity.TableDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TableDBRepository extends JpaRepository<TableDB, Long> {
}
