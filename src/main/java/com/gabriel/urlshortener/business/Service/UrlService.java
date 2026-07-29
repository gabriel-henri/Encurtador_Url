package com.gabriel.urlshortener.business.Service;

import com.gabriel.urlshortener.infra.entity.Url;
import com.gabriel.urlshortener.infra.repository.UrlRepository;
import com.gabriel.urlshortener.util.ShortUrlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public List<String> criarShortUrl(String url){
        ShortUrlGenerator gen = new ShortUrlGenerator();
        String shortUrl;
        List<String> originalUrls = urlRepository.findAllShortUrls();
        while(true){
            shortUrl = gen.gererate(6);
            if(!originalUrls.contains(shortUrl)){
                break;
            }
        }
        List<String> ans = List.of(url, "https://short.local/" + shortUrl);
        return ans;
    }
}
