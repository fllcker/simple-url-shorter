package ru.fllcker.urlshorter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.fllcker.urlshorter.dto.CreateLinkDto;
import ru.fllcker.urlshorter.exceptions.SimpleHttpException;
import ru.fllcker.urlshorter.models.Link;
import ru.fllcker.urlshorter.repositories.ILinksRepository;
import ru.fllcker.urlshorter.utils.RandomString;

/**
 * @author github.com/fllcker
 */
@Service
public class LinksService {
    private final ILinksRepository linksRepository;
    private final ObjectMapper objectMapper;

    public LinksService(ILinksRepository linksRepository, ObjectMapper objectMapper) {
        this.linksRepository = linksRepository;
        this.objectMapper = objectMapper;
    }

    public Link create(CreateLinkDto createLinkDto) {
        Link newLink = objectMapper.convertValue(createLinkDto, Link.class);
        newLink.setAccessHash(RandomString.generateString(10));
        linksRepository.save(newLink);
        return newLink;
    }

    public Link getByAccessHash(String hash) throws SimpleHttpException {
        return linksRepository.findByAccessHash(hash)
                .orElseThrow(() -> new SimpleHttpException(HttpStatus.NOT_FOUND, "Link not found!"));
    }
}
