package com.gabriel.urlshortener.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="urls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String original_url;
    @Column(nullable = false, unique = true)
    private String short_url;
    @Column(nullable = false)
    private LocalDateTime data_criacao;
    @Column(nullable = false)
    private LocalDateTime data_expiracao;
}
