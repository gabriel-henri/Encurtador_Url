package com.gabriel.urlshortener.controller;


import com.gabriel.urlshortener.business.Service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    ResponseEntity<List<String>> createShort(@RequestBody String url){
        System.out.println("URL recebida: " + url);
        return ResponseEntity.ok(urlService.criarShortUrl(url));
    }
}
