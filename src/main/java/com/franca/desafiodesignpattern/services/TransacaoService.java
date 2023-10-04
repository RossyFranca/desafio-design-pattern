package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.models.Transacao;
import com.franca.desafiodesignpattern.repository.ContaRepository;
import com.franca.desafiodesignpattern.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private ContaRepository contaRepository;

    public boolean realizarDeposito(Long idConta, double valor) {

        Conta conta = contaRepository.findById(idConta).orElse(null);
        if (conta == null || conta.getSaldo() < valor) {
            return false; // Não foi possível realizar o saque
        }


        Transacao transacao = new Transacao();
        transacao.setDataHora(LocalDateTime.now());
        transacao.setTipo("DEPOSITO");
        transacao.setValor(valor);
        transacao.setConta(conta);


        double novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);


        transacaoRepository.save(transacao);
        contaRepository.save(conta);
        return true;
    }


    public boolean realizarSaque(Long idConta, double valor) {
        Conta conta = contaRepository.findById(idConta).orElse(null);
        if (conta == null || valor <= 0) {
            return false; // Não foi possível realizar o depósito
        }

        // Verifique se há saldo suficiente
        double saldoAtual = conta.getSaldo();
        if (saldoAtual < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }

        // Crie uma transação de saque e associe à conta
        Transacao transacao = new Transacao();
        transacao.setDataHora(LocalDateTime.now());
        transacao.setTipo("SAQUE");
        transacao.setValor(valor);
        transacao.setConta(conta);

        // Atualize o saldo da conta
        double novoSaldo = saldoAtual - valor;
        conta.setSaldo(novoSaldo);

        // Salve a transação e atualize a conta
        transacaoRepository.save(transacao);
        contaRepository.save(conta);
        return true;
    }

    public List<Transacao> getTransacoesPorIdConta(Long idConta) {
        // Consulte o repositório de Transacao para recuperar as transações por idConta
        return transacaoRepository.findAllByContaId(idConta);
    }
}
