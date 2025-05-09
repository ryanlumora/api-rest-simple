package com.example.mechanic.conserto.database;

import com.example.mechanic.conserto.model.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
     List<Conserto> findAllByAtivoTrue();
}
