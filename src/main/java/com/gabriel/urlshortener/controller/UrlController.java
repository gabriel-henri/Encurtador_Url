package com.gabriel.urlshortener.controller;


import com.gabriel.urlshortener.business.Service.UrlService;
import com.gabriel.urlshortener.infra.dto.UrlRequestDto;
import com.gabriel.urlshortener.infra.dto.UrlResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    ResponseEntity<UrlResponseDto> createShort(@RequestBody UrlRequestDto url){
        return ResponseEntity.ok(urlService.criarShortUrl(url));
    }
}
