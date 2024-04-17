package com.urlshortener.urlshortener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "url")
@Data
@EqualsAndHashCode(callSuper = true)
public class UrlEntity extends BaseEntity {
    @Id
    Long id;
    @Column(name = "long_url")
    String longUrl;
    @Column(name = "short_url")
    String shortUrl;
}
