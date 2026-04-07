package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fag.lucasmartins.arquitetura_software.application.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.application.services.PessoaService;

@Configuration
public class ServiceConfig {

    @Bean
    public PessoaService pessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        return new PessoaService(pessoaRepositoryPort);
    }
}