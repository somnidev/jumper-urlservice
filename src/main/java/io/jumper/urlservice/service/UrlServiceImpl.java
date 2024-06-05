package io.jumper.urlservice.service;

import io.jumper.urlservice.model.UrlData;
import io.jumper.urlservice.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Optional<UrlData> getLongUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    @Override
    public Optional<UrlData> saveUrl(String shortUrl, String longUrl, String userid) {
        var urlToSave = new UrlData(shortUrl, longUrl, userid);
        return Optional.of(urlRepository.save(urlToSave));
    }

}
