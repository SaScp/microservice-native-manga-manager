package ru.alex.mangaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.mangaservice.model.Manga;

@Repository
public interface MangaRepository/* extends JpaRepository<Manga, String>*/ {
}
