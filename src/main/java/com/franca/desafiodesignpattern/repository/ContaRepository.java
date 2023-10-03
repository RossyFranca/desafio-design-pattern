package com.franca.desafiodesignpattern.repository;

import com.franca.desafiodesignpattern.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta,Long> {
}
