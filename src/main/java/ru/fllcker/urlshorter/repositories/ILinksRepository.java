package ru.fllcker.urlshorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fllcker.urlshorter.models.Link;

import java.util.Optional;

@Repository
public interface ILinksRepository extends JpaRepository<Link, Integer> {
    Optional<Link> findByAccessHash(String accessHash);
}
