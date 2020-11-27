package com.monsoko.training.springboot.comicbookslibrary.service;

import com.monsoko.training.springboot.comicbookslibrary.domain.Album;
import com.monsoko.training.springboot.comicbookslibrary.exception.ResourceNotFoundException;
import com.monsoko.training.springboot.comicbookslibrary.repositorie.AlbumRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepositorie albumRepositorie;

    @Override
    public Album saveAlbum(Album album) {
        if (album.getTitle() == null || album.getTitle().isEmpty()) {

        }
        return albumRepositorie.save(album);
    }

    @Override
    public void deleteAlbum(Long id) {
        if(id == null) throw new ResourceNotFoundException("vous devez saisir un titre");
        albumRepositorie.deleteById(id);
    }

    @Override
    public Album findAlbumById(Long id) {
        if (id == null) throw new ResourceNotFoundException("l'identifiant ne doit pas etre null");
        return albumRepositorie.findAlbumById(id);
    }


}
