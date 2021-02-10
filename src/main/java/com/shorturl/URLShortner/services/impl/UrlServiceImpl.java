package com.shorturl.URLShortner.services.impl;

import com.shorturl.URLShortner.models.Url;
import com.shorturl.URLShortner.models.UrlHistory;
import com.shorturl.URLShortner.repositories.UrlHistoryRepository;
import com.shorturl.URLShortner.repositories.UrlRepository;
import com.shorturl.URLShortner.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    UrlRepository urlRepository;
    @Autowired
    UrlHistoryRepository urlHistoryRepository;

    //Method to calculate 6-digit hash value
    private String calcHash(){
        String randomHash = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for(int index = 0; index <= 5; index++){
            randomHash+= possibleChars.charAt((int)Math.floor(Math.random()*possibleChars.length()));
        }
        return randomHash;
    }

    //Method to add new URL to database
    @Override
    public Url addNewUrl(String url){
        Optional<Url> existingUrl = urlRepository.findByLongUrl(url);

        if(existingUrl.isPresent()){
            setUrlHistory(existingUrl.get().getId(), "ACCESSED");
            return existingUrl.get();
        }
        else {
            String base = "http://localhost:8080/";
            String hash = calcHash();

            Url newUrl = new Url();
            newUrl.setHash(hash);
            newUrl.setLongUrl(url);
            newUrl.setShortUrl(base + hash);

            Url urlCreated = urlRepository.save(newUrl);

            Optional<Url> currentUrl = urlRepository.findByLongUrl(url);
            setUrlHistory(urlCreated.getId(), "CREATED");
            return newUrl;
        }
    }

    //Method to save URL access history to database
    private void setUrlHistory(Long urlId, String accessType){
        Optional<Url> existingUrl = urlRepository.findById(urlId);

        UrlHistory urlHistory = new UrlHistory();

        urlHistory.setUrlId(existingUrl.get().getId());
        urlHistory.setAccessType(accessType);

        urlHistoryRepository.save(urlHistory);
    }
}
