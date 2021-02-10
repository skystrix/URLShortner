package com.shorturl.URLShortner.controllers;

import com.shorturl.URLShortner.models.Url;
import com.shorturl.URLShortner.models.UrlHistory;
import com.shorturl.URLShortner.repositories.UrlHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/history")
public class UrlHistoryController {
    @Autowired
    private UrlHistoryRepository urlHistoryRepository;

    //Get request to Display URL access information
    @GetMapping(path="/")
    public Iterable<UrlHistory> getAllHistory() {
        return urlHistoryRepository.findAll();
    }
}
