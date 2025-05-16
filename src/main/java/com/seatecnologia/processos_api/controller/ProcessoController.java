package com.seatecnologia.processos_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatecnologia.processos_api.models.Processo;
import com.seatecnologia.processos_api.repository.ProcessoRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/processos")
public class ProcessoController {

    private final ProcessoRepository processoRepository;

    public ProcessoController(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    // Listar todos os processos
    @GetMapping
    public List<Processo> listar() {
        return processoRepository.findAll();
    }

    // Buscar processo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Processo> buscarPorId(@PathVariable Long id) {
        return processoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo processo
    @PostMapping
    public Processo criar(@Valid @RequestBody Processo processo) {
        return processoRepository.save(processo);
    }

    // Atualizar processo
    @PutMapping("/{id}")
    public ResponseEntity<Processo> atualizar(@PathVariable Long id, @Valid 
    @RequestBody Processo processoAtualizado) {
        return processoRepository.findById(id)
                .map(processo -> {
                    processo.setNumeroProcesso(processoAtualizado.getNumeroProcesso());
                    processo.setAssunto(processoAtualizado.getAssunto());
                    processo.setDataAbertura(processoAtualizado.getDataAbertura());
                    processo.setStatus(processoAtualizado.getStatus());
                    Processo atualizado = processoRepository.save(processo);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Deletar processo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return processoRepository.findById(id)
                .map(processo -> {
                    processoRepository.delete(processo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
