package com.franca.desafiodesignpattern.services;

import com.franca.desafiodesignpattern.models.Cliente;
import com.franca.desafiodesignpattern.models.Conta;
import com.franca.desafiodesignpattern.repository.ClienteRepository;
import com.franca.desafiodesignpattern.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ContaRepository contaRepository;


    public void createNewClient(Cliente cliente){
           String password = cliente.getPassword();
           cliente.setPassword(encoder.encode(password));
           clienteRepository.save(cliente);
    };

    public Cliente buscarClientePorCpf(String cpf){
            return clienteRepository.findByCpf(cpf);
    };

    public Cliente criarCliente(Cliente cliente){
        Conta conta = new Conta();
        //TODO: melhoras lógica para obrigar a iniciar a criação com um depósito mínimo
        // para se criar uma conta ou algo parecido
        conta.setSaldo(0.0);
        cliente.setConta(conta);

        contaRepository.save(conta);

        return clienteRepository.save(cliente);
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
