package com.franca.desafiodesignpattern.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_transacoes")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String tipo; // Pode ser "SAQUE" ou "DEPOSITO"
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta; // Adicione o atributo conta

}
