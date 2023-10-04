package com.franca.desafiodesignpattern.repository;

import com.franca.desafiodesignpattern.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    @Query("SELECT t FROM Transacao t WHERE t.conta.id = :idConta")
    List<Transacao> findAllByContaId(Long idConta);
}
