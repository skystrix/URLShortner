package com.shorturl.URLShortner;

import static org.junit.Assert.assertEquals;
import com.shorturl.URLShortner.models.Url;
import com.shorturl.URLShortner.repositories.UrlHistoryRepository;
import com.shorturl.URLShortner.repositories.UrlRepository;
import com.shorturl.URLShortner.services.impl.UrlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest {
    @InjectMocks
    UrlServiceImpl urlService;

    @Mock
    UrlRepository urlRepository;
    @Mock
    UrlHistoryRepository urlHistoryRepository;

    @Test
    public void addNewUrl_whenValidRequest_thenReturnRecord(){
        String url = "https://stackoverflow.com/questions/45056027/spring-boot-restarter-not-initialized";
        Url response = urlService.addNewUrl(url);

        assertEquals(response.getLongUrl(),url);
        assertEquals(6,response.getHash().length());

    }

}
