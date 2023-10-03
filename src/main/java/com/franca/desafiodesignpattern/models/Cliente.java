package com.franca.desafiodesignpattern.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @Column(name = "cpf_cliente",length = 11, nullable = false)
    private String cpf;
    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String password;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Conta conta;
}
