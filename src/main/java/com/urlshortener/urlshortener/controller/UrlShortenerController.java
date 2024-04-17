package com.urlshortener.urlshortener.controller;

import com.urlshortener.urlshortener.dto.UrlDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.urlshortener.urlshortener.service.UrlShortenerService;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @PostMapping
    @RequestMapping("/create")
    public UrlDTO create(@RequestParam String url) {
        return urlShortenerService.create(url);
    }

    @GetMapping
    @Cacheable(key = "#url", value = "URL")
    @RequestMapping("/{url}")
    public String get(@PathVariable String url) {
        return urlShortenerService.get(url).getLongUrl();
//        return new RedirectView(longUrl);
    }
}
