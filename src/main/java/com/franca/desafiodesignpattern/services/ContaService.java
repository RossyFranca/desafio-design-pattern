package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.models.Transacao;
import com.franca.desafiodesignpattern.repository.ContaRepository;
import com.franca.desafiodesignpattern.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private  ContaRepository contaRepository;

}
