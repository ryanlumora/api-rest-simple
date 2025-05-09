package com.example.mecanic.veiculo.database;

import com.example.mecanic.veiculo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
