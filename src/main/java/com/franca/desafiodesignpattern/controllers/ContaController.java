package com.franca.desafiodesignpattern.controllers;

import com.franca.desafiodesignpattern.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    public ContaService contaService;

    @PostMapping("/{contaId}/saque")
    public ResponseEntity<String> realizarSaque(@PathVariable Long contaId, @RequestParam double valor) {
        boolean saqueBemSucedido = contaService.realizarSaque(contaId, valor);
        if (saqueBemSucedido) {
            return ResponseEntity.ok("Saque realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o saque.");
        }
    }

    @PostMapping("/{contaId}/deposito")
    public ResponseEntity<String> realizarDeposito(@PathVariable Long contaId, @RequestParam double valor) {
        boolean depositoBemSucedido = contaService.realizarDeposito(contaId, valor);
        if (depositoBemSucedido) {
            return ResponseEntity.ok("Depósito realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o depósito.");
        }
    }
}
