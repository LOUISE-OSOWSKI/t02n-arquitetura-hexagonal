package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.application.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.domain.PessoaBO;

public class PessoaService {
    
    private final PessoaRepositoryPort repositoryPort;

    public PessoaService(PessoaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PessoaBO cadastrar(PessoaBO pessoaBO) {
        return repositoryPort.salvar(pessoaBO);
    }
}