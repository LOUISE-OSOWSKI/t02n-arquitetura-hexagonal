package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.domain.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.entities.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.repositories.SpringDataPessoaRepository;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final SpringDataPessoaRepository springRepository;

    public PessoaRepositoryAdapter(SpringDataPessoaRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        PessoaEntity entity = new PessoaEntity();
        entity.setId(pessoaBO.getId());
        entity.setNomeCompleto(pessoaBO.getNomeCompleto());
        entity.setCpf(pessoaBO.getCpf());
        entity.setDataNascimento(pessoaBO.getDataNascimento());
        entity.setEmail(pessoaBO.getEmail());
        entity.setTelefone(pessoaBO.getTelefone());

        PessoaEntity entitySalva = springRepository.save(entity);

        return new PessoaBO(
            entitySalva.getId(),
            entitySalva.getNomeCompleto(),
            entitySalva.getCpf(),
            entitySalva.getDataNascimento(),
            entitySalva.getEmail(),
            entitySalva.getTelefone()
        );
    }
}