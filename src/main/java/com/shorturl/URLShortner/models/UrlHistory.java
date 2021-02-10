package com.shorturl.URLShortner.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UrlHistory {
    @Id
    @GeneratedValue
    Long id;
    Long urlId;
    String accessType;
    //Date updatedAt;

    public UrlHistory(){}

    public UrlHistory(Long id, Long urlId, String accessType) {
        this.id = id;
        this.urlId = urlId;
        this.accessType = accessType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
