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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "cpf_cliente",length = 11, nullable = false)
    private String cpf;
    @Column(length = 50, nullable = false)
    private String nome;


    @OneToOne(cascade = CascadeType.ALL) // Isso permite que as operações no cliente sejam aplicadas à conta
    @JoinColumn(name = "id_conta", referencedColumnName = "id_conta") // Mapeamento da coluna de chave estrangeira
    private Conta conta;
}
