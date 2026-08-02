package com.gabriel.urlshortener.controller;


import com.gabriel.urlshortener.business.Service.UrlService;
import com.gabriel.urlshortener.infra.dto.MessageResponseDto;
import com.gabriel.urlshortener.infra.dto.UrlRequestDto;
import com.gabriel.urlshortener.infra.dto.UrlResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/api/shorten")
    ResponseEntity<UrlResponseDto> createShort(@RequestBody UrlRequestDto url){
        return ResponseEntity.ok(urlService.criarShortUrl(url));
    }

    @GetMapping("/api/links")
    ResponseEntity<List<UrlResponseDto>> listShort(){
        return ResponseEntity.ok(urlService.listarShortUrls());
    }

    @DeleteMapping("/api/links/{shortCode}")
    ResponseEntity<MessageResponseDto> deleteShort(@PathVariable String shortCode){
        urlService.deleteShortUrl(shortCode);

        return ResponseEntity.ok(new MessageResponseDto("Link deleted successfully"));
    }

    @GetMapping("/{shortCode}")
    ResponseEntity<Void> redirectShort(@PathVariable String shortCode,
                                       HttpServletRequest request){
        URI destination = urlService.redirect(shortCode, request);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(destination)
                .build();
    }
}
