package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private  ContaRepository contaRepository;



}
