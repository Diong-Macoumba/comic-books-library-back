package com.monsoko.training.springboot.comicbookslibrary.service;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import com.monsoko.training.springboot.comicbookslibrary.exception.ResourceNotFoundException;
import com.monsoko.training.springboot.comicbookslibrary.repositorie.ComicRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComicServiceImlp implements ComicService {

    @Autowired
    private ComicRepositorie comicRepositorie;

    @Override
    public Comic saveComic(Comic comic) {
        if (comic.getScriptWriter() == null || comic.getScriptWriter().isEmpty())
            throw new ResourceNotFoundException("vous devez renseigner un scriptWriter");
        return comicRepositorie.save(comic);
    }

    @Override
    public Comic updateComic(Long id, Comic comic) {
        if (id == null) throw new IllegalArgumentException("l'identifiant ne doit pas etre null");
        comic.setIdComic(id);
        if (comic.getScriptWriter() == null || comic.getScriptWriter().isEmpty())
            throw new ResourceNotFoundException();
        return comicRepositorie.save(comic);
    }

    @Override
    public void deleteComic(Long id) {
        if(id == null) throw new ResourceNotFoundException("l'identifiant ne doit pas etre null");
        comicRepositorie.deleteById(id);

    }

    @Override
    public List<Comic> getAllComics() {
        return comicRepositorie.findAll();
    }

    @Override
    public Comic findComicById(Long id) {
        if (id == null) throw new ResourceNotFoundException("l'identifiant ne doit pas etre null");
        return comicRepositorie.findComicById(id);
    }

    @Override
    public Comic findComicByTitle(String title) {
        if (title == null) throw new ResourceNotFoundException("vous devez renseigner un titre");
        return comicRepositorie.findComicByTitle(title);
    }
}
