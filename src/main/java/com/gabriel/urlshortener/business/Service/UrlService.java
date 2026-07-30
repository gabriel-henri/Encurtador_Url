package com.gabriel.urlshortener.business.Service;

import com.gabriel.urlshortener.infra.dto.UrlRequestDto;
import com.gabriel.urlshortener.infra.dto.UrlResponseDto;
import com.gabriel.urlshortener.infra.entity.Url;
import com.gabriel.urlshortener.infra.repository.UrlRepository;
import com.gabriel.urlshortener.util.ShortUrlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlResponseDto criarShortUrl(UrlRequestDto requestDto){
        ShortUrlGenerator gen = new ShortUrlGenerator();
        String shortUrl;
        while(true){
            shortUrl = gen.generate(6);
            if(!urlRepository.existsByShortUrl(shortUrl)){
                break;
            }
        }
        LocalDateTime now = LocalDateTime.now();
        Url url = new Url(requestDto.originalUrl(), shortUrl, now, now.plusDays(30));
        urlRepository.save(url);

        return new UrlResponseDto(url.getOriginalUrl(), "https://short.local/" + url.getShortUrl());
    }

    public List<UrlResponseDto> listarShortUrls(){
        List<Url> urls = urlRepository.findAll();
        List<UrlResponseDto> responses = new ArrayList<>();

        for (Url url:
             urls) {
            responses.add(new UrlResponseDto(url.getOriginalUrl(), "https://short.local/" + url.getShortUrl()));
        }
        return responses;
    }

    @Transactional
    public void deleteShortUrl(String req){
        Url url = urlRepository.findByShortUrl(req)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        urlRepository.delete(url);
    }
}
