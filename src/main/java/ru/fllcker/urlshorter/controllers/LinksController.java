package ru.fllcker.urlshorter.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.fllcker.urlshorter.dto.CreateLinkDto;
import ru.fllcker.urlshorter.exceptions.SimpleHttpException;
import ru.fllcker.urlshorter.models.Link;
import ru.fllcker.urlshorter.services.LinksService;

/**
 * @author github.com/fllcker
 */
@RestController
@RequestMapping("links")
public class LinksController {
    private final LinksService linksService;

    public LinksController(LinksService linksService) {
        this.linksService = linksService;
    }

    @PostMapping
    public Link create(@RequestBody @Valid CreateLinkDto createLinkDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var error = bindingResult.getAllErrors()
                    .stream().findFirst();
            if (error.isPresent())
                throw new SimpleHttpException(HttpStatus.BAD_REQUEST, error.get().getCode());
        }

        return linksService.create(createLinkDto);
    }

    @GetMapping("{hash}")
    public String getByAccessHash(@PathVariable String hash) {
        return linksService.getByAccessHash(hash).getTargetURL();
    }

    @ExceptionHandler(SimpleHttpException.class)
    public ResponseEntity handlerException(SimpleHttpException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body(e.getMessage());
    }
}
