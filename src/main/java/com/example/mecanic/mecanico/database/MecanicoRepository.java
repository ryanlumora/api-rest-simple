package com.example.mecanic.mecanico.database;

import com.example.mecanic.mecanico.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
