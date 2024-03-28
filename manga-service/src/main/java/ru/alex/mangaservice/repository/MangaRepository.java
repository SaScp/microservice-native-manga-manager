package ru.alex.mangaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.mangaservice.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, String> {
}
