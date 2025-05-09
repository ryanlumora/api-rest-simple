package com.example.mechanic.conserto.controller;

import com.example.mechanic.conserto.DadosAtualizacaoConserto;
import com.example.mechanic.conserto.DadosConserto;
import com.example.mechanic.conserto.DadosListagemConserto;
import com.example.mechanic.conserto.database.ConsertoRepository;
import com.example.mechanic.conserto.Conserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> listarConsertoPorID(@PathVariable Long id) {
            Optional<Conserto> consertoOptional = repository.findById(id);
            return consertoOptional.isPresent() ? ResponseEntity.ok(consertoOptional.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
    }
}
