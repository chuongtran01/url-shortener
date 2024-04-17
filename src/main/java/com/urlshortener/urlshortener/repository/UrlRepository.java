package com.urlshortener.urlshortener.repository;

import com.urlshortener.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    @Query(value = "SELECT u FROM UrlEntity u WHERE u.longUrl = :longUrl")
    Optional<UrlEntity> findByLongUrl(@Param("longUrl") final String longUrl);

    @Query(value = "SELECT u FROM UrlEntity u WHERE u.shortUrl = :shortUrl")
    Optional<UrlEntity> findByShortUrl(@Param("shortUrl") final String shortUrl);
}
