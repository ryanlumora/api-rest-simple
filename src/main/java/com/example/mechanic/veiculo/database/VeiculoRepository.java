package com.example.mechanic.veiculo.database;

import com.example.mechanic.veiculo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
