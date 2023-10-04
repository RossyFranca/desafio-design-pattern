package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.exceptions.DepositoMinimoException;
import com.franca.desafiodesignpattern.models.Cliente;
import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.repository.ClienteRepository;
import com.franca.desafiodesignpattern.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContaRepository contaRepository;


    public Cliente buscarClientePorCpf(String cpf){
            return clienteRepository.findByCpf(cpf);
    };

    public Cliente criarCliente(Cliente cliente){
        Conta conta = new Conta();
        //TODO: Verificar forma de retornar a exception pelo controller
        verificarSaldoMinimoDeAbertura(cliente.getConta().getSaldo());
        conta.setSaldo(cliente.getConta().getSaldo());
        // Associe a conta ao cliente
        cliente.setConta(conta);

        return clienteRepository.save(cliente);
    }
    private void verificarSaldoMinimoDeAbertura(double saldo){
        if(saldo <= 0.0)
            throw new DepositoMinimoException("Para abertura de conta é necessário algum depósito");
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + id));


        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpf(clienteAtualizado.getCpf());


        return clienteRepository.save(clienteExistente);
    }
}
