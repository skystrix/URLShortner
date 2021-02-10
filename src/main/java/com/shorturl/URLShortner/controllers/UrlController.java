package com.shorturl.URLShortner.controllers;

import com.shorturl.URLShortner.models.Url;
import com.shorturl.URLShortner.repositories.UrlRepository;
import com.shorturl.URLShortner.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping
public class UrlController {
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private UrlService urlService;

    //Get request to view all URL information
    @GetMapping(path="/url/all")
    public
    Iterable<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    //Get request to view URL information for a particular ID
    @GetMapping(path="/url/{id}")
    public
    Optional<Url> getAllUsers(@PathVariable Long id) {
        Optional<Url> existingUrl = urlRepository.findById(id);

        if(existingUrl.isPresent()){
            return existingUrl;
        }
        else{
            return Optional.empty();
        }

    }

    //Post request to add a new short URL for a Long URL
    @PostMapping(path="/")
    public ResponseEntity<Url> addNewUrl (@RequestBody String url) {
        return new ResponseEntity<>(urlService.addNewUrl(url), HttpStatus.OK);
    }

    //Redirect request to redirect from short URL to long URL
    @GetMapping(path="/{hash}")
    public void getFullUrl (HttpServletResponse response, @PathVariable("hash") String hash) throws IOException {
        String fullUrl = "http://localhost:8080/" + hash;
        Optional<Url> existingUrl = urlRepository.findByShortUrl(fullUrl);
        response.sendRedirect(existingUrl.get().getLongUrl());
    }
}
