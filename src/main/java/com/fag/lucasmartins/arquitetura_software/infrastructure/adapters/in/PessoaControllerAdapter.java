package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.lucasmartins.arquitetura_software.application.services.PessoaService;
import com.fag.lucasmartins.arquitetura_software.domain.PessoaBO;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaService pessoaService;

    public PessoaControllerAdapter(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody PessoaBO requestData) {
        try {
            PessoaBO novoBo = new PessoaBO(
                null, 
                requestData.getNomeCompleto(),
                requestData.getCpf(),
                requestData.getDataNascimento(),
                requestData.getEmail(),
                requestData.getTelefone()
            );

            PessoaBO boSalvo = pessoaService.cadastrar(novoBo);
            return ResponseEntity.ok(boSalvo);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("erro", "Erro inesperado: " + e.getMessage()));
        }
    }
}