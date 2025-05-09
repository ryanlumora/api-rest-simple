package com.example.mechanic.mecanico.database;

import com.example.mechanic.mecanico.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
