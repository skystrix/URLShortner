package com.shorturl.URLShortner.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private Long id;
    private String hash;
    private String shortUrl;
    private String longUrl;
    public Url(){};
    public Url(String hash, String shortUrl, String longUrl) {
        this.hash = hash;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {

        return "Url{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
