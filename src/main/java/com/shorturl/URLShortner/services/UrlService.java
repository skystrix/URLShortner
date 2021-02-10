package com.shorturl.URLShortner.services;

import com.shorturl.URLShortner.models.Url;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UrlService {
    public Url addNewUrl(String url);
}
