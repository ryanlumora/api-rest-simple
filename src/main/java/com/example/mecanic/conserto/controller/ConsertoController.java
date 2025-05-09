package com.example.mecanic.conserto.controller;

import com.example.mecanic.conserto.database.ConsertoRepository;
import com.example.mecanic.conserto.model.Conserto;
import com.example.mecanic.conserto.model.DadosConserto;
import com.example.mecanic.conserto.model.DadosListagemConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados){
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlguns(){
        return repository.findAll().stream().map(DadosListagemConserto::new).toList();
    }
}
