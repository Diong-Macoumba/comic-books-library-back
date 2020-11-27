package com.monsoko.training.springboot.comicbookslibrary.service;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;

import java.util.List;

public interface ComicService {

    public Comic saveComic( Comic comic );
    public Comic updateComic( Long id, Comic comic );
    public void deleteComic( Long id );
    public List<Comic> getAllComics();
    public Comic findComicById( Long id );
    public Comic findComicByTitle( String title );
}
