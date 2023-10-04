package com.franca.desafiodesignpattern.controllers;

import com.franca.desafiodesignpattern.models.Transacao;
import com.franca.desafiodesignpattern.services.ContaService;
import com.franca.desafiodesignpattern.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    public TransacaoService transacaoService;

    @PostMapping("/{contaId}/saque")
    public ResponseEntity<String> realizarSaque(@PathVariable Long contaId, @RequestParam double valor) {
        boolean saqueBemSucedido = transacaoService.realizarSaque(contaId, valor);
        if (saqueBemSucedido) {
            return ResponseEntity.ok("Saque realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o saque.");
        }
    }

    @PostMapping("/{contaId}/deposito")
    public ResponseEntity<String> realizarDeposito(@PathVariable Long contaId, @RequestParam double valor) {
        boolean depositoBemSucedido = transacaoService.realizarDeposito(contaId, valor);
        if (depositoBemSucedido) {
            return ResponseEntity.ok("Depósito realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o depósito.");
        }
    }
  @GetMapping("/{contaId}/extrato")
    public List<Transacao> getExtrato(@PathVariable Long contaId) {
        // Recupere o extrato da conta com o ID especificado
        return transacaoService.getTransacoesPorIdConta(contaId);
    }

}
