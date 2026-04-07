package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.entities.PessoaEntity;

@Repository
public interface SpringDataPessoaRepository extends JpaRepository<PessoaEntity, UUID> {
}