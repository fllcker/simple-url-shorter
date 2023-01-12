package ru.fllcker.urlshorter.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author github.com/fllcker
 */
@Entity
@Table(name = "links")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "access_hash")
    private String accessHash;

    @NotNull
    @Column(name = "target_url")
    private String targetURL;
}
