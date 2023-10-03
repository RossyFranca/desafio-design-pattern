package com.franca.desafiodesignpattern.repository;

import com.franca.desafiodesignpattern.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}
