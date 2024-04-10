package com.casotti.cars.domain.model;

import com.casotti.cars.domain.brand.Brand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "modelo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Brand brand;

    @Column(name = "valor_fipe", nullable = false)
    private BigDecimal fipeValue;

}
