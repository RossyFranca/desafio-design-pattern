package com.franca.desafiodesignpattern.repository;

import com.franca.desafiodesignpattern.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
}
