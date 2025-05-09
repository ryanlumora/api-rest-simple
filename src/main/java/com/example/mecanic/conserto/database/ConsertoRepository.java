package com.example.mecanic.conserto.database;

import com.example.mecanic.conserto.model.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
