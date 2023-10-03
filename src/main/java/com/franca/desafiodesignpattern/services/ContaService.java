package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.models.Transacao;
import com.franca.desafiodesignpattern.repository.ContaRepository;
import com.franca.desafiodesignpattern.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContaService {

    @Autowired
    private  ContaRepository contaRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    public boolean realizarSaque(Long contaId, double valor) {
        Conta conta = contaRepository.findById(contaId).orElse(null);
        if (conta == null || conta.getSaldo() < valor) {
            return false; // Não foi possível realizar o saque
        }

        Transacao saque = new Transacao();
        saque.setDataHora(LocalDateTime.now());
        saque.setTipo("SAQUE");
        saque.setValor(valor);
        saque.setConta(conta);


        conta.adicionarTransacao(saque);

        // Atualize o saldo da conta e salve
        conta.setSaldo(conta.getSaldo() - valor);
        contaRepository.save(conta);

        return true; // Saque bem-sucedido
    }

    public boolean realizarDeposito(Long contaId, double valor) {
        Conta conta = contaRepository.findById(contaId).orElse(null);
        if (conta == null || valor <= 0) {
            return false; // Não foi possível realizar o depósito
        }

        // Crie uma nova transação de depósito
        Transacao deposito = new Transacao();
        deposito.setDataHora(LocalDateTime.now());
        deposito.setTipo("DEPOSITO");
        deposito.setValor(valor);
        deposito.setConta(conta);

        // Associe a transação à conta usando o método adicionarTransacao
        conta.adicionarTransacao(deposito);

        // Atualize o saldo da conta e salve
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.save(conta);

//        // Salve a transação no repositório de transações
//        transacaoRepository.save(deposito);

        return true; // Depósito bem-sucedido
    }


}
