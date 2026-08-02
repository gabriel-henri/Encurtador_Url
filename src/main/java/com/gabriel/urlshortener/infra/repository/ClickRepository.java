package com.gabriel.urlshortener.infra.repository;

import com.gabriel.urlshortener.infra.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {
}
