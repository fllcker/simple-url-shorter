package ru.fllcker.urlshorter.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author github.com/fllcker
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkDto {
    @Size(max = 100, message = "Url is too big!")
    private String targetURL;
}
