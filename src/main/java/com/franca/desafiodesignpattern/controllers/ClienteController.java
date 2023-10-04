package com.franca.desafiodesignpattern.controllers;

import com.franca.desafiodesignpattern.exceptions.DepositoMinimoException;
import com.franca.desafiodesignpattern.models.Cliente;
import com.franca.desafiodesignpattern.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente buscarClientePorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    @PostMapping("/")
    public Cliente criarCliente(@RequestBody Cliente cliente)  {
        return clienteService.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

}
