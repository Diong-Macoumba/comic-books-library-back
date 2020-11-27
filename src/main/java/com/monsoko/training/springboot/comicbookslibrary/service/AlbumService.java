package com.monsoko.training.springboot.comicbookslibrary.service;

import com.monsoko.training.springboot.comicbookslibrary.domain.Album;

public interface AlbumService {

    public Album saveAlbum( Album album );
    public void deleteAlbum(Long id );
    public Album findAlbumById( Long id );
}
