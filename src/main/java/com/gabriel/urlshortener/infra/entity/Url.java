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

    @Column(name="original_url", nullable = false)
    private String originalUrl;
    @Column(name="short_url", nullable = false, unique = true)
    private String shortUrl;
    @Column(name="data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @Column(name="data_expiracao", nullable = false)
    private LocalDateTime dataExpiracao;
}
