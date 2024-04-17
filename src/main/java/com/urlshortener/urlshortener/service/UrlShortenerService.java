package com.urlshortener.urlshortener.service;

import com.urlshortener.urlshortener.dto.UrlDTO;
import com.urlshortener.urlshortener.encoder.Base10Encoder;
import com.urlshortener.urlshortener.encoder.BaseEncoder;
import com.urlshortener.urlshortener.entity.UrlEntity;
import com.urlshortener.urlshortener.exception.ResourceNotFoundException;
import com.urlshortener.urlshortener.generator.UUIDGenerator;
import com.urlshortener.urlshortener.generator.UUIDGeneratorImpl;
import com.urlshortener.urlshortener.mapper.UrlMapper;
import com.urlshortener.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {
    final private UrlRepository urlRepository;
    final private UrlMapper urlMapper;

    public UrlDTO create(String longUrl) {
        Optional<UrlEntity> urlEntity = urlRepository.findByLongUrl(longUrl);

        if (urlEntity.isPresent()) return urlMapper.toDto(urlEntity.get());

        UUIDGenerator uuidGenerator = UUIDGeneratorImpl.uuidGenerator;
        Long UUID = uuidGenerator.create();

        BaseEncoder base62Encoder = Base10Encoder.BASE_62;
        String shortUrl = base62Encoder.encode(UUID);

        UrlEntity urlEntity1 =  UrlEntity.builder().id(UUID).longUrl(longUrl).shortUrl(shortUrl).build();
        urlRepository.save(urlEntity1);

        return  urlMapper.toDto(urlRepository.save(urlEntity1));
    }

    public UrlDTO get(String shortUrl) {
        UrlEntity urlEntity = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new ResourceNotFoundException(String.format("URL %s cannot be found", shortUrl)));
        return urlMapper.toDto(urlEntity);
    }
}
