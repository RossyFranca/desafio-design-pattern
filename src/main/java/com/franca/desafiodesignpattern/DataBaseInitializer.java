package com.franca.desafiodesignpattern;

import com.franca.desafiodesignpattern.models.Cliente;
import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataBaseInitializer {
    @Autowired
    private ClienteService clienteService;

    @PostConstruct
    public void initialize() {
        // Crie a conta de teste
        Conta contaTeste = new Conta();
        contaTeste.setSaldo(0.0);

        // Crie o cliente associado à conta
        Cliente clienteTeste = new Cliente();
        clienteTeste.setCpf("11730404889");
        clienteTeste.setNome("Rossy Franca");
        clienteTeste.setConta(contaTeste);

        // Salve o cliente com a conta no banco de dados
        clienteService.criarCliente(clienteTeste);
    }

}
