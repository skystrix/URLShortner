package com.shorturl.URLShortner.repositories;

import com.shorturl.URLShortner.models.Url;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Long> {
    Optional<Url> findByShortUrl( String shortUrl );
    Optional<Url> findByLongUrl( String longUrl );
}
