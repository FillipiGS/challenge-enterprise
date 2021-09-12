package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "META")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private double valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_visivel")
    private boolean visivel;

    @Column(name = "alerta")
    private boolean alerta;

}
