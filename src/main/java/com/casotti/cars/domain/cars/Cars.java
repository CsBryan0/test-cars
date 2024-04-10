package com.casotti.cars.domain.cars;

import com.casotti.cars.domain.model.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "timestamp_cadastro")
    private LocalDateTime register;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Model model;

    @Column(name = "ano", nullable = false)
    private int year;

    @Column(name = "combustivel", nullable = false)
    private String fuel;

    @Column(name = "num_portas", nullable = false)
    private int doorsNumbers;

    @Column(name = "cor", nullable = false)
    private String color;
}
