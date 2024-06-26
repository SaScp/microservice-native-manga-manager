package ru.alex.mangaservice.service.impl;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.mangaservice.repository.MangaRepository;
import ru.alex.mangaservice.service.MangaService;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultMangaService implements MangaService {
/*

    private final MangaRepository mangaRepository;

    private final MangaConverter mangaConverter;

    private PageRequest pageRequest;

    private List<Manga> mangas;

    private String order;

    private boolean orderFlag = true;


    @Override
    public Manga save(MangaDto mangaDto) {
        Manga manga = mangaConverter.convertTo(mangaDto);
        mangaDto.setId(UUID.randomUUID().toString());
        mangaRepository.save(manga);
        return manga;
    }

    @Override
    public List<Manga> search(SearchEntity search) {
        this.pageRequest = PageRequest.of(search.getPage(), 20);
        return mangaRepository.findByMainNameStartingWithOrSecondaryNameStartingWith(search.getTitle(), this.pageRequest);
    }

    @Override
    @Transactional
    public List<Manga> findAll(FilterEntity filterEntity) {
        checkOrderOnStartsWithPlus(filterEntity.getOrder());
        if (filterEntity.getOrder() != null) {
            Sort sort = orderFlag ? Sort.by(this.order).descending() : Sort.by(this.order).ascending();
            this.pageRequest = PageRequest.of(filterEntity.getPageNumber(),filterEntity.getPageSize(), sort);
        } else {
            this.pageRequest = PageRequest.of(filterEntity.getPageNumber(),filterEntity.getPageSize());
        }
        checkAllParams(order, filterEntity.getTypes(), filterEntity.getGenres());
        return mangas;
    }

    @Override
    @Transactional(readOnly = true)
    public Manga findMangaById(String id) {
        return this.mangaRepository.findById(id)
                .orElseThrow(() -> new MangaNotFoundException("Manga with id: " + id + " Not Found"));
    }

    private void checkAllParams(String order,
                                List<Long> types,
                                List<Long> genreIds
    ) {
        if (genreIds != null && types != null && order != null) {
            mangas = this.mangaRepository.findAllByTypeInAndGenresIn(types, genreIds, pageRequest);
        } else {
            checkGenresOrTypeOrder(order, types, genreIds);
        }
    }

    private void checkGenresOrTypeOrder(String order,
                                        List<Long> types,
                                        List<Long> genreIds
    ) {
        if (genreIds != null && order != null) {
            mangas = this.mangaRepository.findAllByGenresIn(genreIds, pageRequest);
        } else if (types != null && order != null) {
            mangas = this.mangaRepository.findAllByTypesIn(types, pageRequest);
        } else {
            checkOrderIsEmpty(order, types, genreIds);
        }
    }

    private void checkOrderIsEmpty(String order,
                                   List<Long> types,
                                   List<Long> genreIds
    ) {
        if (genreIds != null && types != null) {
            mangas = this.mangaRepository.findAllByTypeInAndGenresIn(types, genreIds, this.pageRequest);
        } else {
            if (order != null) {
                mangas = this.mangaRepository.findAll(pageRequest).toList();
            } else {
                checkTypesAndGenresIds(order, types, genreIds);
            }
        }

    }

    private void checkTypesAndGenresIds(String order,
                                        List<Long> types,
                                        List<Long> genreIds
    ) {
        if (types != null) {
            mangas = this.mangaRepository.findAllByTypesIn(types, this.pageRequest);
        } else {
            if (genreIds != null) {
                mangas = this.mangaRepository.findAllByGenresIn(genreIds, this.pageRequest);
            } else {
                mangas = this.mangaRepository.findAll(this.pageRequest).toList();
            }
        }
    }

    private void checkOrderOnStartsWithPlus(String order) {
        if (order != null) {
            this.orderFlag = order.startsWith(" ");
            this.order = order.substring(1);
        }
    }

*/

}
