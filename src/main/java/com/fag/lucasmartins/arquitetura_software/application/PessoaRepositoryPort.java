package com.fag.lucasmartins.arquitetura_software.application;

import com.fag.lucasmartins.arquitetura_software.domain.PessoaBO;

public interface PessoaRepositoryPort {
    PessoaBO salvar(PessoaBO pessoaBO);
}