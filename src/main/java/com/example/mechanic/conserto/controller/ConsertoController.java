package com.example.mechanic.conserto.controller;

import com.example.mechanic.conserto.model.*;
import com.example.mechanic.conserto.database.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder){
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao));
    }

    @GetMapping("algunsdados")
    public ResponseEntity listarAlguns(){
        return ResponseEntity.ok(repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity listarConsertoPorID(@PathVariable Long id) {
            Optional<Conserto> consertoOptional = repository.findById(id);
            return consertoOptional.isPresent() ?
                    ResponseEntity.ok(new DadosDetalhamentoConserto(consertoOptional.get()))
                    : ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
