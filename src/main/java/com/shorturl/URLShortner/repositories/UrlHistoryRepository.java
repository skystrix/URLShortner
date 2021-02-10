package com.shorturl.URLShortner.repositories;

import com.shorturl.URLShortner.models.UrlHistory;
import org.springframework.data.repository.CrudRepository;

public interface UrlHistoryRepository extends CrudRepository<UrlHistory, Long> {
}
