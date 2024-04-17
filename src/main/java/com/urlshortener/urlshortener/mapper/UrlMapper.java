package com.urlshortener.urlshortener.mapper;

import com.urlshortener.urlshortener.dto.UrlDTO;
import com.urlshortener.urlshortener.entity.UrlEntity;
import com.urlshortener.urlshortener.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrlMapper extends EntityMapper<UrlEntity, UrlDTO> {
}
